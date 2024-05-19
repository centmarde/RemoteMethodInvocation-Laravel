$(document).ready(function() {
    // Handle save button click
    $(document).ready(function() {
        $('#saveButton').click(function() {
            var courseId = $('#courseId').val();
            var studentId = $('#studentId').val();
    
            $.ajax({
                url: 'http://rmilaravel.test/api/enrollment/store',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    student_id: studentId,
                    course_id: courseId
                }),
                success: function(response) {
                    alert('Student enrolled successfully!');
                    console.log(response);
                    window.location.reload();
                },
                error: function(xhr, status, error) {
                    alert('An error occurred. Please try again.');
                    console.error(xhr, status, error);
                }
            });
        });
    });
    
    // Handle individual enrollment removal
    $('.remove-button').click(function() {
        var button = $(this);
        var enrollmentId = button.data('enrollment-id');

        var confirmDelete = confirm("Are you sure you want to delete this enrollment?");

        if (confirmDelete) {
            $.ajax({
                url: 'http://rmilaravel.test/api/enrollments/' + enrollmentId,
                method: 'DELETE',
                contentType: 'application/json',
                success: function(response) {
                    if (response.ok) {
                        button.closest('tr').remove();
                       /*  window.location.reload(); */
                    } else {
                        console.error('Error:', response.statusText);
                    }
                    alert("deleted successfully");
                    window.location.reload();
                },
                error: function(xhr, status, error) {
                    console.error('Error:', error);
                }
            });
        }
    });

    // Handle deletion of all courses
    $('#delete-all-courses-button').click(function() {
        var confirmDelete = confirm("Are you sure you want to delete all courses?");

        if (confirmDelete) {
            $.ajax({
                url: 'http://rmilaravel.test/api/courses_delete',
                method: 'DELETE',
                success: function(response) {
                    alert(response.message);
                   
                    window.location.reload();
                },
                error: function(xhr, status, error) {
                    alert('Error: ' + xhr.responseJSON.error);
                }
            });
        }
    });

    // Handle individual course removal
    $('.remove-button-course').click(function() {
        var button = $(this);
        var courseId = button.data('course-id');

        var confirmDelete = confirm("Are you sure you want to delete this course?");

        if (confirmDelete) {
            $.ajax({
                url: 'http://rmilaravel.test/api/courses/' + courseId,
                method: 'DELETE',
                contentType: 'application/json',
                success: function(response) {
                    if (response.ok) {
                        button.closest('tr').remove();
                       
                    } else {
                        console.error('Error:', response.statusText);
                    }
                    alert("deleted successfully");
                    window.location.reload();
                   
                },
                error: function(xhr, status, error) {
                    alert('Error:', error);
                }
            });
          
        }
    });

    // Handle student form submission
    $('#student_form').on('submit', function(e) {
        e.preventDefault();

        const studentData = {
            student_id: $('#student_id').val(),
            name: $('#name').val(),
            age: $('#age').val(),
            contact_number: $('#contact_number').val(),
            address: $('#address').val()
        };

        $.ajax({
            url: 'http://rmilaravel.test/api/enrollment/student_add',
            type: 'POST',
            data: JSON.stringify(studentData),
            contentType: 'application/json',
            success: function(response) {
                alert('Student added successfully');
                $('#student_form')[0].reset();
                $('.text-danger').empty();
                window.location.reload();
            },
            error: function(xhr) {
                if (xhr.status === 422) {
                    const errors = xhr.responseJSON.errors;
                    $('.text-danger').empty();
                    if (errors.student_id) {
                        $('#error_student_id').text(errors.student_id[0]);
                    }
                    if (errors.name) {
                        $('#error_name').text(errors.name[0]);
                    }
                    if (errors.age) {
                        $('#error_age').text(errors.age[0]);
                    }
                    if (errors.contact_number) {
                        $('#error_contact_number').text(errors.contact_number[0]);
                    }
                    if (errors.address) {
                        $('#error_address').text(errors.address[0]);
                    }
                } else {
                    alert('Error adding student');
                }
            }
        });
    });

    // Handle course form submission
    $('#course_form').on('submit', function(e) {
        e.preventDefault();

        const courseData = {
            course_id: $('#course_id').val(),
            course_title: $('#course_title').val(),
            course_description: $('#course_description').val()
        };

        $.ajax({
            url: 'http://rmilaravel.test/api/courses/course_add',
            type: 'POST',
            data: JSON.stringify(courseData),
            contentType: 'application/json',
            success: function(response) {
                alert('Course added successfully');
                $('#course_form')[0].reset();
                $('.text-danger').empty();
                window.location.reload();
            },
            error: function(xhr) {
                if (xhr.status === 422) {
                    const errors = xhr.responseJSON.errors;
                    $('.text-danger').empty();
                    if (errors.course_id) {
                        $('#error_course_id').text(errors.course_id[0]);
                    }
                    if (errors.course_title) {
                        $('#error_course_title').text(errors.course_title[0]);
                    }
                    if (errors.course_description) {
                        $('#error_course_description').text(errors.course_description[0]);
                    }
                } else {
                    alert('Error adding course');
                }
            }
        });
    });
});
