<!-- layout.blade.php -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@yield('title')</title>
    <!-- Additional styles/scripts -->
</head>
<body>
    <!-- Navbar, header, etc. -->

    <div class="container">
        @yield('content1') <!-- Content 1 -->
    </div>

    <div class="container">
        @yield('content2') <!-- Content 2 -->
    </div>

    <div class="container">
        @yield('content3') <!-- Content 3 -->
    </div>

    <div class="container">
        @yield('content4') <!-- Content 4 -->
    </div>

    <div class="container">
        @yield('content5') <!-- Content 5 -->
    </div>

    <!-- Footer, scripts, etc. -->
</body>
</html>

<!-- child.blade.php -->

@extends('layout')

@section('title', 'Page Title')

@section('content1')
    <!-- Content 1 -->
    <p>Content 1 here</p>
@endsection

@section('content2')
    <!-- Content 2 -->
    <p>Content 2 here</p>
@endsection

@section('content3')
    <!-- Content 3 -->
    <p>Content 3 here</p>
@endsection

@section('content4')
    <!-- Content 4 -->
    <p>Content 4 here</p>
@endsection

@section('content5')
    <!-- Content 5 -->
    <p>Content 5 here</p>
@endsection
