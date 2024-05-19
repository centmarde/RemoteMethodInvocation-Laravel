<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\courses_model;
use Illuminate\Http\Request;
use SimpleXMLElement;
use Illuminate\Support\Facades\Log;


class CourseControllerApi extends Controller
{
    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validatedData = $request->validate([
            'course_id' => 'required|string',
            'course_title' => 'required|string',
            'course_description' => 'required|string',
        ]);

        $course = courses_model::create($validatedData);

        $xmlFile = storage_path('Courses.xml');

        if (!file_exists($xmlFile)) {
            $xml = new SimpleXMLElement('<Courses/>');
        } else {
            $xml = simplexml_load_file($xmlFile);
        }

        $courseXml = $xml->addChild('Course');
        $courseXml->addAttribute('course_id', $validatedData['course_id']);
        $courseXml->addAttribute('course_title', $validatedData['course_title']);
        $courseXml->addAttribute('course_description', $validatedData['course_description']);

        $xml->asXML($xmlFile);

        return response()->json([
            'message' => 'Course added successfully',
            'courses' => $course,
        ], 201);
    }


    public function destroy(string $id)
    {
       $course = courses_model::findOrFail($id);
       $course->delete();
       return $course;
    }

    public function deleteAllCourses(Request $request)
    {
        // Path to the Courses.xml file
        $path = storage_path('Courses.xml');

        // Check if the file exists
        if (!file_exists($path)) {
            return response()->json(['error' => 'Courses.xml file not found.'], 404);
        }

        try {
            // Load the XML file
            $xml = simplexml_load_file($path);
            if ($xml === false) {
                return response()->json(['error' => 'Failed to load Courses.xml file.'], 500);
            }

            // Remove all course entries
            $courses = $xml->xpath('/Courses/Course');
            if ($courses === false) {
                return response()->json(['error' => 'Failed to parse Courses.xml file.'], 500);
            }

            foreach ($courses as $course) {
                unset($course[0]);
            }

            // Save the changes back to the XML file
            if ($xml->asXML($path) === false) {
                return response()->json(['error' => 'Failed to save changes to Courses.xml file.'], 500);
            }

            return response()->json(['message' => 'All courses have been deleted successfully.'], 200);
        } catch (\Exception $e) {
            // Log the exception for debugging purposes
            Log::error('Error deleting all courses: ' . $e->getMessage());

            return response()->json(['error' => 'An unexpected error occurred while deleting courses. Please try again later.'], 500);
        }
    }
}
