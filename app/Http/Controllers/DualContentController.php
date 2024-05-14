<?php

namespace App\Http\Controllers;

use App\Models\Students;
use App\Models\courses_model;
use Illuminate\Http\Request;

class DualContentController extends Controller
{
    public function showDualContent()
    {
        $courses = courses_model::all();
        $students = Students::all();

        return view('dashboard', ['courses' => $courses, 'students' => $students]);
    }
}