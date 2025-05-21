<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Student Management System</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="{{asset('css/app.css?v=').time()}}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sedan+SC&display=swap" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        .hover-card {
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .hover-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.12), 0 4px 8px rgba(0,0,0,0.06) !important;
        }
        .action-button {
            transition: all 0.3s;
        }
        .action-button:hover {
            transform: scale(1.05);
        }
        .form-card {
            border-radius: 10px;
        }
        .sidebar-card {
            position: sticky;
            top: 1rem;
        }
        #indexbody {
            background-color: #f8f9fa;
        }
        .card-header {
            border-radius: 0.375rem 0.375rem 0 0;
        }
        @media (max-width: 767.98px) {
            .sidebar-card {
                position: static;
            }
        }
    </style>
</head>

<body class="antialiased" id="indexbody">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow sticky-top">
        <div class="container">
            <div class="navbar-brand">
                <h2 class="mb-0"><i class="fas fa-graduation-cap me-2"></i>Students Dashboard</h2>
            </div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="{{ url('/') }}">
                            <i class="fas fa-home me-1"></i> Home
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="container-fluid py-4">
        <div class="row g-4">
            <!-- Main content area -->
            <div class="col-lg-8 mb-4">
                <div class="mb-4">
                    @yield('content')
                </div>
                <div class="mb-4">
                    @yield('content2')
                </div>
                <div class="mb-4">
                    @yield('content3')
                </div>
                
                <div class="card shadow-sm hover-card form-card">
                    <div class="card-header bg-warning">
                        <h4 class="mb-0 text-dark"><i class="fas fa-user-plus me-2"></i>Add a Student</h4>
                    </div>
                    <div class="card-body">
                        <form id="student_form">
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Student ID" name="student_id" id="student_id">
                                        <label for="student_id">Student Id</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Name" name="name" id="name">
                                        <label for="name">Name</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Age" name="age" id="age">
                                        <label for="age">Age</label>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Contact Number" name="contact_number" id="contact_number">
                                        <label for="contact_number">Contact Number</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Address" name="address" id="address">
                                        <label for="address">Address</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button id="submit_student" class="btn btn-primary action-button w-100" type="submit">
                                        <i class="fas fa-save me-1"></i> Submit Student
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
            <!-- Sidebar content area -->
            <div class="col-lg-4">
                <div class="card shadow-sm hover-card form-card mb-4 sidebar-card">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0"><i class="fas fa-book-open me-2"></i>Add a Course</h4>
                    </div>
                    <div class="card-body">
                        <form id="course_form">
                            <div class="row g-3">
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Course ID" name="course_id" id="course_id">
                                        <label for="course_id">Course Id</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter title" name="course_title" id="course_title">
                                        <label for="course_title">Course Title</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input class="form-control" placeholder="Enter Description" name="course_description" id="course_description">
                                        <label for="course_description">Description</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button id="submit_course" class="btn btn-success action-button w-100" type="submit">
                                        <i class="fas fa-save me-1"></i> Submit Course
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card shadow-sm hover-card form-card mb-4 sidebar-card">
                    <div class="card-header bg-info text-white">
                        <h4 class="mb-0"><i class="fas fa-user-graduate me-2"></i>Enroll a Student</h4>
                    </div>
                    <div class="card-body">
                        <div class="row g-3">
                            <div class="col-md-6">
                                <div class="form-floating">
                                    <input class="form-control" placeholder="Enter Course ID" id="courseId">
                                    <label for="courseId">Course Id</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating">
                                    <input class="form-control" placeholder="Enter Student ID" id="studentId">
                                    <label for="studentId">Student Id</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="button" class="btn btn-info action-button w-100 text-white" id="saveButton">
                                    <i class="fas fa-check-circle me-1"></i> Enroll Student
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="card shadow-sm hover-card form-card sidebar-card">
                    <div class="card-header bg-secondary text-white">
                        <h4 class="mb-0"><i class="fas fa-cogs me-2"></i>Management Actions</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-grid gap-3">
                            <button type="button" id="delete-all-courses-button" class="btn btn-danger action-button">
                                <i class="fas fa-trash-alt me-1"></i> Delete All Courses
                            </button>
                            <button type="button" id="delete-all-students-button" class="btn btn-danger action-button">
                                <i class="fas fa-trash-alt me-1"></i> Delete All Students
                            </button>
                            <a href="{{ url('/') }}" class="btn btn-light action-button border">
                                <i class="fas fa-home me-1"></i> Go to Splash Screen
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <footer class="bg-dark text-white py-4 mt-5">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h5>Student Management System</h5>
                    <p class="small">Manage your students and courses efficiently</p>
                </div>
                <div class="col-md-6 text-md-end">
                    <p class="small">© 2023 All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom JS -->
    <script src="{{ asset('js/welcome.js') }}?v={{ time() }}"></script>
</body>

</html>