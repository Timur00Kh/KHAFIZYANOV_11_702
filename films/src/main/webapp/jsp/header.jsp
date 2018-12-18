<%@ page import="java.util.Optional" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Films</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addSubj">Добавить</a>
            </li>
            <li class="nav-item dropdown">
                <a itemid="history_btn" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Последние действия на сайте
                </a>
                <div  class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <ul id="history" style="max-height: 80vh; overflow-x: hidden; overflow-y: scroll"  class="list-group list-group-flush">

                    </ul>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            </li>
            <!--<li class="nav-item">-->
            <!--<button class="btn btn-outline-success ml-1" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>-->
            <!--</li>-->
        </ul>

        <%
            Optional<User> user = (Optional<User>) request.getAttribute("user");

        %>
        <ul class="navbar-nav ml-2" id="user_min" style="display: ${user.isPresent() ? "" : "none"}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle dropdown-toggle-split" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img id="user_min_img" class="rounded-circle img-fluid" style="height: 40px; border-width: 1px !important;" src='${user.isPresent() && user.get().getAvatarUrl() != null ? user.get().getAvatarUrl() : "/img/default_avatar.png"}'>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" id="user_min_name" href="/profile">${user.isPresent() ? user.get().getName() : ''}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Мои Листы</a>
                    <a class="dropdown-item" href="#">История действий</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" id="exit_btn" href="#">Выйти</a>
                </div>
            </li>
        </ul>

        <ul class="navbar-nav ml-2" id="login_btn" style="display: ${user.isPresent() ? "none" : ""}">
            <li class="nav-item">
                <button class="btn btn-outline-info ml-1" data-toggle="modal" data-target="#signModal">Sign In</button>
            </li>
        </ul>


    </div>
</nav>


<!-- Modal -->
<div class="modal fade" id="signModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Hello world!</h5>
                <button type="button" id="close_btn" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body py-2 px-0">
                <ul class="nav nav-pills nav-justified px-3" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Sign In</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Sign Up</a>
                    </li>

                </ul>
                <hr class="my-2">
                <div class="alert alert-danger mx-3 mt-1" style="display: none" id="alert" role="alert">
                    <i class="fas fa-exclamation-triangle"></i> <span>123</span>
                </div>
                <div class="tab-content px-3 my-2" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="form-group">
                            <label for="signin_name">Nick name</label>
                            <input type="text" class="form-control" id="signin_name" aria-describedby="emailHelp" placeholder="Enter nickname">
                        </div>
                        <div class="form-group">
                            <label for="signin_pass">Password</label>
                            <input type="password" class="form-control" id="signin_pass" placeholder="Password">
                        </div>
                        <div class="row justify-content-end">
                            <div class="col-auto mt-2">
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input" id="">
                                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                </div>
                            </div>
                            <div class="col-auto">
                                <button type="submit" id="signin_btn" class="btn btn-primary btn-lg">Submit</button>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="form-group">
                            <label for="signup_name">Nick name</label>
                            <input type="email" class="form-control" id="signup_name" aria-describedby="emailHelp" placeholder="Enter nickname">
                        </div>
                        <div class="form-group">
                            <label for="signup_pass">Password</label>
                            <input type="password" class="form-control" id="signup_pass" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="signup_pass2">Check password</label>
                            <input type="password" class="form-control" id="signup_pass2" placeholder="Password">
                        </div>
                        <div class="row justify-content-end">
                            <div class="col-auto mt-2">
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                </div>
                            </div>
                            <div class="col-auto">
                                <button type="submit" id="signup_btn" class="btn btn-primary btn-lg">Submit</button>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">3</div>
                </div>
            </div>
        </div>
    </div>
</div>