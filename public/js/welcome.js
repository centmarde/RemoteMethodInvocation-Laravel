$(document).ready(function() {
    $('#saveButton').click(function() {
        var courseId = $('#courseId').val();
        var studentName = $('#studentName').val();

        $.ajax({
            url: 'http://rmilaravel.test/api/enrollment/store',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                student_id: studentName,
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

    $(document).ready(function() {
        // Select all buttons with the class 'remove-button'
        $('.remove-button').click(function() {
            var button = $(this); // Store reference to the button element
            var enrollmentId = button.data('enrollment-id');
            
            // Ask for confirmation
            var confirmDelete = confirm("Are you sure you want to delete this enrollment?");
            
            // Proceed with deletion if confirmed
            if(confirmDelete){
                // Make AJAX request to the API endpoint
                $.ajax({
                    url: 'http://rmilaravel.test/api/enrollments/' + enrollmentId,
                    method: 'DELETE',
                    contentType: 'application/json',
                    success: function(response) {
                        if (response.ok) {
                            // If the request is successful, remove the table row
                            button.closest('tr').remove();
                            // Reload the page
                           
                        } else {
                            // If there's an error, log it to the console
                            console.error('Error:', response.statusText);
                        }
                        window.location.reload();
                    },
                    error: function(xhr, status, error) {
                        console.error('Error:', error);
                    }
                });
            }
        });
    });

    $(document).ready(function() {
        $('#student_form').on('submit', function(e) {
            e.preventDefault(); // Prevent the default form submission

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
                    // Optionally, clear the form fields after successful submission
                    $('#student_form')[0].reset();
                    $('.text-danger').empty(); // Clear previous error messages
                    window.location.reload();
                },
                error: function(xhr) {
                    if (xhr.status === 422) { // Validation error
                        const errors = xhr.responseJSON.errors;
                        // Clear previous error messages
                        $('.text-danger').empty();
                        // Display new error messages
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
    });
    
});
