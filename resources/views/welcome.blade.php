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
    <script src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs" type="module"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body class="antialiased" id="indexbody" style="height: 100vh;
    overflow: hidden;
    position: relative;">
    <div class="custom-shape-divider-top-1715081876">
       <!--  <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z" class="shape-fill"></path>
        </svg> -->
    </div>

    <div class="container">

        <div class="row">
            <div class="col-8">
                <br><br><br><br><br><br><br><br><br>
                <h1 class="text-center" id="title">Remote Method Invocation</h1>

                <a href="{{ url('/dashboard') }}" class=" mt-5 mx-5 d-flex justify-content-center btn btn-outline-light">Go to Dashboard</a>
              

            </div>

            <div class="col-4">
                <br><br><br> <br>
              <dotlottie-player
  src="https://lottie.host/ab597091-b05c-4d37-84b9-874211e54cdb/qKK06fEQQ7.lottie"
  background="transparent"
  speed="1"

  loop
  autoplay
></dotlottie-player>
            </div>

        </div>

       



        <!-- Anchor button to redirect to backend.test/dashboard -->

    </div>

    <script src="{{ asset('js/app.js') }}"></script>
    <script>
        // Use jQuery to fade in the element with the specified id
        $(document).ready(function() {
            $("#title").fadeIn(); // Fade in the element with id "title"
        });
    </script>
</body>

</html>