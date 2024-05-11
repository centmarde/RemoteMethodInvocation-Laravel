<!-- dashboard.blade.php -->

@extends('layouts.app')

@section('content')
    <div class="container">
       
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>FullName</th>
                    <th>Program</th>
                    <th>Course</th>
                    
                </tr>
            </thead>
            <tbody>
                @foreach ($students as $students)
                    <tr>
                        <td>{{ $students->student_id }}</td>
                        <td>{{ $students->fullname }}</td>
                        <td>{{ $students->program }}</td>
                        <td>{{ $students->course }}</td>
                    
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>
@endsection
