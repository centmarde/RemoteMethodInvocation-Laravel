<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class courses_model extends Model
{
    use HasFactory;

    protected $table = 'courses'; 

    protected $primaryKey = 'id';

    protected $fillable = [
        'course_id',
        'student_id',
        'course_title',
        'course_description',
    ];
}
