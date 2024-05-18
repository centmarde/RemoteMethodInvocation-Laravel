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
    
});
