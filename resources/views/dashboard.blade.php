@extends('layouts.app')

@section('content')
<div class="container">
    <table class="table">
        <h2>List of all Students</h2>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Address</th>
                <th>Contact Number</th>
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
            </tr>
            @endforeach
        </tbody>
    </table>
</div>
@endsection

@section('content2')
<div class="container">
    <table class="table">
        <h2>Courses Offered</h2>
        <thead>
            <tr>
                <th>Course Id</th>
                <th>Course Title</th>
                <th>Course Description</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($courses as $course)
            <tr>
                <td>{{ $course->course_id }}</td>
                <td>{{ $course->course_title }}</td>
                <td>{{ $course->course_description }}</td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>
@endsection

@section('content3')
<div class="container">
    <table class="table">
        <h2>Already Enrolled</h2>
        <thead>
            <tr>
                <th>Course Id</th>
                <th>Student Id</th>
                <th>Name</th>
                <th>Title</th>
                <th></th> <!-- Added a new column for the buttons -->
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
        <button type="button" class="btn btn-danger remove-button" data-enrollment-id="{{ $enrollment->id }}">Remove</button>
    </td>
</tr>
@endforeach


    </table>
</div>
@endsection