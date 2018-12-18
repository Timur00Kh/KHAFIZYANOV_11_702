/*
let navSearch = document.getElementById("nav_search");
let navSearchContainer = document.getElementById("nav_search_container");
let navSearchEl = document.querySelector(".nav_search_el");
navSearchEl.remove();

navSearchContainer.addSubj = function(name, year) {
    let cur = navSearchEl.cloneNode(true);
    cur.querySelector(".search-name").innerText = name;
    cur.querySelector(".search-year > span").innerText = year;
    cur.title = name + " - " + year;
    navSearchContainer.append(cur);
};



navSearch.addEventListener("focus", function () {
    if (!document.querySelector(".nav_search_el")) return;
    navSearchContainer.className += " show";
});
navSearch.hideSearch = function () {
    navSearchContainer.className =
        navSearchContainer.className
            .split(" ")
            .filter(function(s) {
                return s !== "show";
            })
            .join(" ");
};
navSearch.addEventListener("blur", navSearch.hideSearch);
let timer;
navSearch.addEventListener("keyup", function () {
    lastQuery = navSearch.value;
    clearTimeout(timer);
    if (lastQuery.length === 0) {
        navSearch.hideSearch();
        return;
    }

    timer = setTimeout(function () {
        console.log(navSearch.value);
        $.ajax({
            type: 'post',
            url: '/getSubj',
            data: {name: navSearch.value}
        }).done(function (data) {
            navSearchContainer.innerText = '';
            navSearch.hideSearch();
            if (data.length > 0)navSearchContainer.className += " show";
            if (data) {
                data.forEach(function (v) {
                    navSearchContainer.addSubj(v.title, v.releaseYear);
                })
            } else navSearch.hideSearch();
        });
    }, 500)
});*/

let timer;
$("#nav_search")
    .on("focus", function () {
        if ($("#nav_search").val().length > 0)
        $("#nav_search_container").addClass('show')
    })
    .on("blur", function () {
        $("#nav_search_container").removeClass('show')
    })
    .on("keyup", function () {
        clearTimeout(timer);
        if ($("#nav_search").val().length === 0) {
            $("#nav_search_container").removeClass('show');
            return;
        }

        timer = setTimeout(function () {
            $.ajax({
                type: 'post',
                url: '/getSubj',
                data: {name: $("#nav_search").val()}
            }).done(function (data) {
                if (!data) return;
                if (data.length > 0) {
                    $("#nav_search_container").addClass('show').html('');
                } else {
                    $("#nav_search_container").removeClass('show')/*.html('')*/;
                }

                data.forEach(function (v) {
                    $("<a>", {
                        class: "dropdown-item py-0 px-3 nav_search_el",
                        href: "#",
                        title: v.title + " - " + v.releaseYear,
                        append: $('<div>', {
                            class: "row",
                            append: $('<div>', {
                                class: "col-9",
                                text: v.title,
                                css: {
                                    overflow: "hidden",
                                    "text-overflow": "ellipsis"
                                }
                            }).add($('<div>', {
                                class: "col-1",
                                append: $("<span>", {
                                    text: v.releaseYear,
                                    class: "small"
                                }),
                            }))
                        })
                    }).appendTo('#nav_search_container');
                })
            });
        }, 500)
    });

$("#nav_search_container").removeClass('show').html('');
