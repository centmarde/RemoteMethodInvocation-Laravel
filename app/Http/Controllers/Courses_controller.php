<?php

namespace App\Http\Controllers;

use App\Models\courses_model;
use App\Models\Students;
use Illuminate\Http\Request;

class Courses_controller extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $courses = courses_model::all();
        return view('dashboard', compact('courses'));
    }

 /*    public function viewData()
    {
        $courses = courses_model::all();
        $students = Students::all();

        return view('dashboard', ['courses' => $courses, 'students' => $students]);
    } */
    
    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
