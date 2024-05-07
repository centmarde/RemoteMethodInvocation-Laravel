<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Laravel</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet" />
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <script src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs" type="module"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body class="antialiased" id="indexbody">
    <div class="custom-shape-divider-top-1715081876">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z" class="shape-fill"></path>
        </svg>
    </div>

    <div class="container">

        <div class="row">
            <div class="col-8">
                <br><br><br><br><br><br><br><br><br>
                <h1 class="text-center" id="title">Remote Method Invocation</h1>

                <a href="http://rmilaravel.test/dashboard" class=" mt-5 mx-5 d-flex justify-content-center btn btn-outline-light">Go to Dashboard</a>
                <div class="d-flex">
                    <h5 class="ms-5 text-light mt-3">Links:</h5><a href="https://github.com/centmarde" target="blank">
                        <i class="text-light ms-2 mt-2 fa fa-github fa-2x" aria-hidden="true"></i>
                    </a>
                    <a href="https://web.facebook.com/centmarde.campado" target="blank">
                        <i class="text-light ms-3 mt-2 fa fa-facebook-official fa-2x" aria-hidden="true"></i>
                    </a>


                </div>

            </div>

            <div class="col-4">
                <br><br><br> <br>
                <dotlottie-player id="svg" src="https://lottie.host/670eed5d-c55d-4137-a607-7110b5bae81b/60FiKmroDV.json" background="transparent" speed="0.8" style="width: 700px;" loop autoplay></dotlottie-player>
            </div>

        </div>




        <!-- Anchor button to redirect to backend.test/dashboard -->

    </div>

    <script src="{{ asset('js/app.js') }}"></script>
    <script>
  // Use jQuery to fade in the element with the specified id
  $(document).ready(function(){
    $("#title").fadeIn(); // Fade in the element with id "title"
  });
</script>
</body>

</html>