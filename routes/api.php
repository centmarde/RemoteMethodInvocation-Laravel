<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\EnrollmentController;
use App\Http\Controllers\Api\StudentsControllerApi;
use App\Http\Controllers\Api\CourseControllerApi;



/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });

Route::post('/enrollment/store', [EnrollmentController::class, 'store']);
Route::post('/enrollment/student_add', [StudentsControllerApi::class, 'store']);
Route::get('/enrollments',[EnrollmentController::class, 'index']);
Route::delete('/enrollments/{id}',[EnrollmentController::class, 'destroy']);


Route::post('/courses/course_add', [CourseControllerApi::class, 'store']);
Route::delete('/courses/{id}',[CourseControllerApi::class, 'destroy']);
Route::delete('/courses_delete', [CourseControllerApi::class, 'deleteAllCourses']);


