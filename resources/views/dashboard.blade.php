<!-- dashboard.blade.php -->

@extends('layouts.app')

@section('content')
    <div class="container">
       
        <table class="table">
            <thead>
                <tr>
                    <th>Product Code</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Store Price</th>
                    <th>Retail Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($products as $products)
                    <tr>
                        <td>{{ $products->product_code }}</td>
                        <td>{{ $products->name }}</td>
                        <td>{{ $products->description }}</td>
                        <td>{{ $products->store_price }}</td>
                        <td>{{ $products->retail_price }}</td>
                        <td>{{ $products->quantity }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>
@endsection
