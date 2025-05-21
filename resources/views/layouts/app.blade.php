<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Laravel</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="{{asset('css/app.css?v=').time()}}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sedan+SC&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <!-- Styles -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body class="antialiased" id="indexbody">
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
        <div class="container">
            <div class="navbar-brand">
                <h1 class="text-center" id="header">Students Dashboard.</h1>
            </div>
        </div>
    </nav>
    <br> <br> <br>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-lg-9">
                <div class="card" style="width: auto;">
                    <div class="card-body">
                        @yield('content')
                    </div>
                </div>
                
                <div class="row mt-3">
                    <div class="col-md-6">
                        <div class="card" style="width: auto;">
                            <div class="card-body">
                                @yield('content2')
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card" style="width: auto;">
                            <div class="card-body">
                                @yield('content3')
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-md-6">
                        <div class="card p-4" style="width: auto; height: 100%;">
                            <h5>Add a Student to XML</h5>
                            <hr>
                            <div class="container">
                                <form id="student_form">
                                    <div class="mb-1">
                                        <div class="form-floating">
                                            <input class="form-control" placeholder="Enter Student ID" name="student_id" id="student_id" style="background-color: #EEEEEE;">
                                            <label for="student_id">Student Id</label>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter Name" name="name" id="name" style="background-color: #EEEEEE;">
                                        <label for="name">Name</label>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter Age" name="age" id="age" style="background-color: #EEEEEE;">
                                        <label for="age">Age</label>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter Contact Number" name="contact_number" id="contact_number" style="background-color: #EEEEEE;">
                                        <label for="contact_number">Contact Number</label>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter Address" name="address" id="address" style="background-color: #EEEEEE;">
                                        <label for="address">Address</label>
                                    </div>
                                    <div class="d-grid mt-4 gap-2">
                                        <button id="submit_student" class="btn btn-primary" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card p-4" style="width: auto; height: 100%;">
                            <h5>Add a Course to XML</h5>
                            <hr>
                            <div class="container">
                                <form id="course_form">
                                    <div class="mb-1">
                                        <div class="form-floating">
                                            <input class="form-control" placeholder="Enter Course ID" name="course_id" id="course_id" style="background-color: #EEEEEE;">
                                            <label for="course_id">Course Id</label>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter title" name="course_title" id="course_title" style="background-color: #EEEEEE;">
                                        <label for="course_title">Course Title</label>
                                    </div>
                                    <div class="form-floating mb-1">
                                        <input class="form-control" placeholder="Enter Description" name="course_description" id="course_description" style="background-color: #EEEEEE;">
                                        <label for="course_description">Description</label>
                                    </div>
                                    <div class="d-grid mt-4 gap-2">
                                        <button id="submit_course" class="btn btn-primary" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="card mt-3 p-4" style="width: auto;">
                    <h3>Enroll a Student</h3>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="form-floating">
                                    <input class="form-control" placeholder="Enter Course ID" id="courseId" style="background-color: #EEEEEE;">
                                    <label for="courseId">Course Id</label>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="form-floating">
                                    <input class="form-control" placeholder="Enter Student ID" id="studentId" style="background-color: #EEEEEE;">
                                    <label for="studentName">Student Id</label>
                                </div>
                            </div>
                            <div class="col-md-2 d-flex align-items-center justify-content-center mt-2 mt-md-0">
                                <button type="button" class="btn btn-primary w-100" id="saveButton">Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 col-lg-3">
                <div class="card" style="width: auto;">
                    <div class="card-body">
                        <h4 class="text-center mb-3">System Information</h4>
                        <p class="text-center">Student and Course Management System</p>
                        <p class="text-center"><small>v1.0.0</small></p>
                    </div>
                </div>

                <div class="card mt-3" style="width: auto;">
                    <div class="card-body">
                        <h4 class="text-center">Project Overview</h4>
                        <p class="text-center">Remote Method Invocation implementation using Laravel and JDBC.</p>
                    </div>
                </div>

                <div class="card mt-3" style="width: auto;">
                    <div class="card-body">
                        <div class="row mb-2">
                            <h5 class="text-center mb-3">Technologies Used</h5>
                            <div class="col-3 col-md-6 text-center mb-2"><img src="{{ asset('jdbc.jpg') }}" width="100%" height="70rem" alt="JDBC"></div>
                            <div class="col-3 col-md-6 text-center mb-2"><img src="{{ asset('laravel.png') }}" width="100%" height="70rem" alt="Laravel"></div>
                            <div class="col-3 col-md-6 text-center"><img src="{{ asset('PHP-logo.svg.png') }}" width="100%" height="50rem" alt="PHP"></div>
                            <div class="col-3 col-md-6 text-center"><img src="{{ asset('mysql-6.svg') }}" width="100%" height="70rem" alt="MySQL"></div>
                        </div>
                    </div>
                </div>

                <div class="d-grid gap-2 col-12 mx-auto mt-3 mb-5">
                    <a type="button" id="delete-all-courses-button" class="btn btn-danger">Delete Contents of Courses XML</a>
                    <a type="button" id="delete-all-students-button" class="btn btn-danger">Delete Contents of Students XML</a>
                    <a type="button" href="{{ url('/') }}" class="mt-2 btn btn-light">Go to Splash Screen</a>
                </div>
            </div>
        </div>
        <br><br><br>

        <script src="{{ asset('js/welcome.js') }}?v={{ time() }}"></script>
    </div>
</body>

</html>