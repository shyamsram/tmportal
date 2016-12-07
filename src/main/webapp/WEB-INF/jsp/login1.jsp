<!DOCTYPE html>
<html>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

</head>
<body>

    <br>
    <div class="container-fluid">
        <div class="panel panel-success">
            <div class="panel-heading" align="center">
                <h1><b><font color="black" style="font-family: fantasy;">Talent Management Login</font>
                Name is : ${userId}
                </b></h1>
            </div>
            <div class="panel-body"align="center">

                <div class="container " style="margin-top: 10%; margin-bottom: 10%;">

                    <div class="panel panel-success" style="max-width: 35%;" align="left">

                        <div class="panel-heading form-group">
                            <b><font color="black">
                                Login Form</font> </b>
                        </div>

                        <div class="panel-body" >

                        <form action="login" method="post" >
                            <div class="form-group">
                                <label for="exampleInputEmail1">User Name</label>
                                <input
                                    type="text" class="form-control" name="userId" id="userId"
                                    placeholder="Enter User Name" required="required" autocomplete="off">

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label> <input
                                    type="password" class="form-control" name="password" id="password"
                                    placeholder="Password" required="required">
                            </div>
                            <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b>Login</b></button>

                        </form>

                        </div>
                    </div>

                </div>

            </div>
            <div class="panel-footer" align="center"><font style="color: #111">Copyright @2016  <a href="http://tcs.com/">TCS</a>, All Rights Reserved. </font></div>
        </div>
    </div>

</body>
</html>