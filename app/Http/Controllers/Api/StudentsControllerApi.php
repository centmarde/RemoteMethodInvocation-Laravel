<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Students;
use SimpleXMLElement;
use Illuminate\Support\Facades\Log;


class StudentsControllerApi extends Controller
{
    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validatedData = $request->validate([
            'student_id' => 'required|string',
            'name' => 'required|string',
            'age' => 'required|integer',
            'contact_number' => 'nullable|string',
            'address' => 'required|string',
        ]);

        
        $student = Students::create($validatedData);

       
        $xmlFile = storage_path('students.xml');
        
     
        if (!file_exists($xmlFile)) {
            $xml = new SimpleXMLElement('<Students/>');
        } else {
            $xml = simplexml_load_file($xmlFile);
        }

      
        $studentXml = $xml->addChild('Student');
        $studentXml->addAttribute('student_id', $validatedData['student_id']);
        $studentXml->addAttribute('name', $validatedData['name']);
        $studentXml->addAttribute('age', $validatedData['age']);
        $studentXml->addAttribute('contact_number', $validatedData['contact_number']);
        $studentXml->addAttribute('address', $validatedData['address']);

      
        $xml->asXML($xmlFile);

        return response()->json([
            'message' => 'Student added successfully',
            'student' => $student,
        ], 201);
    }

    public function destroy(string $id)
    {
       $student = Students::findOrFail($id);
       $student->delete();
       return $student;
    }


    public function deleteAllStudents(Request $request)
{
    // Path to the Students.xml file
    $path = storage_path('Students.xml');

    // Check if the file exists
    if (!file_exists($path)) {
        return response()->json(['error' => 'Students.xml file not found.'], 404);
    }

    try {
        // Load the XML file
        $xml = simplexml_load_file($path);
        if ($xml === false) {
            return response()->json(['error' => 'Failed to load Students.xml file.'], 500);
        }

        // Remove all student entries
        $students = $xml->xpath('/Students/Student');
        if ($students === false) {
            return response()->json(['error' => 'Failed to parse Students.xml file.'], 500);
        }

        foreach ($students as $student) {
            unset($student[0]);
        }

        // Save the changes back to the XML file
        if ($xml->asXML($path) === false) {
            return response()->json(['error' => 'Failed to save changes to Students.xml file.'], 500);
        }

        return response()->json(['message' => 'All students have been deleted successfully.'], 200);
    } catch (\Exception $e) {
        // Log the exception for debugging purposes
        Log::error($e->getMessage());

        return response()->json(['error' => 'An unexpected error occurred while deleting students. Please try again later.'], 500);
    }
}

}
