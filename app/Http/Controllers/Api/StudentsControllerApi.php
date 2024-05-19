<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Students;
use SimpleXMLElement;

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
}
