<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\courses_model;
use Illuminate\Http\Request;
use SimpleXMLElement;

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
}
