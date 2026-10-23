
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
</head>
<body>
    <p>
        Dear ${headers.lastName}, ${headers.firstName}
    </p>

    <p>
        Thanks for the order of ${headers.item}.
    </p>

    <p>
        Regards,<br>
        Camel Riders Bookstore
    </p>

    <hr>

    <div>
        ${body}
    </div>
</body>
</html>
