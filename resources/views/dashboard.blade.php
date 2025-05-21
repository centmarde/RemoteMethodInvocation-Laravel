@extends('layouts.app')

@section('content')
<div class="container-fluid">
    <div class="card shadow-sm hover-card">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0"><i class="fas fa-users me-2"></i>List of all Students</h4>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-light">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Address</th>
                            <th>Contact Number</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach ($students as $student)
                        <tr>
                            <td>{{ $student->student_id }}</td>
                            <td>{{ $student->name }}</td>
                            <td>{{ $student->age }}</td>
                            <td>{{ $student->address }}</td>
                            <td>{{ $student->contact_number }}</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm remove-button-student" data-student-id="{{ $student->student_id }}">
                                    <i class="fas fa-trash-alt me-1"></i> Remove
                                </button>
                            </td>
                        </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
@endsection

@section('content2')
<div class="container-fluid">
    <div class="card shadow-sm hover-card">
        <div class="card-header bg-success text-white">
            <h4 class="mb-0"><i class="fas fa-book me-2"></i>Courses Offered</h4>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-light">
                        <tr>
                            <th>Course Id</th>
                            <th>Course Title</th>
                            <th>Course Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach ($courses as $course)
                        <tr>
                            <td>{{ $course->course_id }}</td>
                            <td>{{ $course->course_title }}</td>
                            <td>{{ $course->course_description }}</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm remove-button-course" data-course-id="{{ $course->course_id }}">
                                    <i class="fas fa-trash-alt me-1"></i> Remove
                                </button>
                            </td>
                        </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
@endsection

@section('content3')
<div class="container-fluid">
    <div class="card shadow-sm hover-card">
        <div class="card-header bg-info text-white">
            <h4 class="mb-0"><i class="fas fa-clipboard-list me-2"></i>Enrollment Records</h4>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-light">
                        <tr>
                            <th>Course Id</th>
                            <th>Student Id</th>
                            <th>Name</th>
                            <th>Title</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach ($enrollment as $enrollment)
                        <tr>
                            <td>{{ $enrollment->course->course_id }}</td>
                            <td>{{ $enrollment->student->student_id }}</td>
                            <td>{{ $enrollment->student->name }}</td>
                            <td>{{ $enrollment->course->course_title }}</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm remove-button" data-enrollment-id="{{ $enrollment->id }}">
                                    <i class="fas fa-trash-alt me-1"></i> Remove
                                </button>
                            </td>
                        </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
@endsection