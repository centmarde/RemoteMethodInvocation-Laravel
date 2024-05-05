<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Products extends Model
{
    use HasFactory;

    protected $table = 'products'; 

    protected $primaryKey = 'product_code';

    protected $fillable = [
        'name',
        'description',
        'store_price',
        'retail_price',
        'quantity',
        'user_id',
    ];
}
