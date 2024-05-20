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
            <div class="col-8">
                <div class="card" style="width: auto;">

                    <div class="card-body">
                        @yield('content')
                    </div>
                </div>
                <div class="card mt-3" style="width: auto;">

                    <div class="card-body">
                        @yield('content2')
                    </div>
                </div>

                <div class="card mt-3" style="width: auto;">

                    <div class="card-body">
                        @yield('content3' )

                    </div>

                </div>

                <br>
                <div class="row">
                    <div class="col">
                        <div class="card p-4" style="width: auto;">
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
                    <div class="col"> <div class="card p-4" style="width: auto;">
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



                        </div></div>
                </div>


            </div>
            <div class="col-4">
                <div class="card" style="width: auto;">
                    <div class="card-body">
                        <div class="d-flex justify-content-center">

                            <div class="mb-5" style="width: 200px; height: 180px;" id="imageContainerMaster">
                                <div><img class="block my-2 border border-dark border-2 rounded-circle" src="{{ asset('marde.jpg') }}" width="100%" height="200rem"></div>

                            </div>

                        </div>
                        <h4 class="text-center">Centmarde J. Campado</h4>
                    </div>
                </div>

                <div class="card mt-3" style="width: auto;">
                    <div class="card-body">
                        <div class="d-flex justify-content-center">

                            <div class="mb-5" style="width: 200px; height: 180px;" id="imageContainer">
                                <div><img class="block my-2 border border-dark border-2 rounded-circle" src="{{ asset('christ.jpg') }}" width="100%" height="200rem"></div>

                            </div>

                        </div>
                        <h4 class="text-center">Christ Gabales</h4>
                    </div>
                </div>

                <div class="card mt-3" style="width: auto;">
                    <div class="card-body">
                        <div class="d-flex justify-content-center">

                            <div class="mb-5" style="width: 200px; height: 180px;" id="imageContainer">
                                <div><img class="block my-2 border border-dark border-2 rounded-circle" src="{{ asset('junkay.jpeg') }}" width="100%" height="200rem"></div>

                            </div>

                        </div>
                        <h4 class="text-center">Jun Kyle Gulay</h4>
                    </div>
                </div>
                <div class="card mt-3" style="width: auto;">
                    <div class="card-body">
                        <div class="row mb-2">
                            <h5 class="text-center mb-3">technology used</h5>
                            <div class="col text-center"><img src="{{ asset('jdbc.jpg') }}" width="100%" height="70rem"></div>
                            <div class="col text-center"><img src="{{ asset('laravel.png') }}" width="100%" height="70rem"></div>
                            <div class="col text-center"><img src="{{ asset('PHP-logo.svg.png') }}" width="100%" height="50rem"></div>
                            <div class="col text-center"><img src="{{ asset('mysql-6.svg') }}" width="100%" height="70rem"></div>
                        </div>

                    </div>

                </div>

                <br>

                <div class="card p-4" style="width: auto;">
                    <h3>Enroll a Student</h3>
                    <div class="container d-flex">
                        <div class="col mx-1">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Enter Course ID" id="courseId" style="background-color: #EEEEEE;"></textarea>
                                <label for="courseId">Course Id</label>
                            </div>
                            <br>
                        </div>
                        <div class="col mx-1">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Enter Student ID" id="studentId" style="background-color: #EEEEEE;"></textarea>
                                <label for="studentName">Student Id</label>
                            </div>
                        </div>
                    </div>

                    <button type="button" class="btn btn-primary" id="saveButton">Save</button>
                </div>
                <div class="d-grid gap-2 col-12 mx-auto mb-5">
                    
                    <a type="button" id="delete-all-courses-button"  class="mt-3 btn btn-danger">Delete Contens of Courses XML</a>
                    <a type="button" id="delete-all-students-button"  class="mt-3 btn btn-danger">Delete Contens of Students XML</a>
                    <a type="button" href="http://rmilaravel.test/" class="mt-3 btn btn-light">Go to Splash Screen</a>
                </div>

            </div>
        </div>
        <br><br><br>
        <!--   <audio controls autoplay loop class="hidden-audio">
            <source src="{{ asset('4200.mp3') }}" type="audio/mpeg">
        </audio>  -->

        <script src="{{ asset('js/welcome.js') }}?v={{ time() }}"></script>


</body>

</html>