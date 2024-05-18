<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Enrollment;

class EnrollmentController extends Controller
{
    public function store(Request $request)
    {
        // Validate the request data
        $validatedData = $request->validate([
            'student_id' => 'required|string|exists:students,student_id',
            'course_id' => 'required|string|exists:courses,course_id',
        ]);

        // Create a new enrollment
        $enrollment = Enrollment::create($validatedData);

        // Return a response
        return response()->json([
            'message' => 'Enrollment created successfully',
            'enrollment' => $enrollment,
        ], 201);
    }

    public function index()
    {
        return Enrollment::all();
    }

    public function destroy(string $id)
    {
       $carouselItem = Enrollment::findOrFail($id);
       $carouselItem->delete();
       return $carouselItem;
    }
}
