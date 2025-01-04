 $("input[type=submit]").click(function () {
        $.ajax({
          url: "http://lnd.cardatastore.net/api/Auth/Login",
            type: "POST",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({
                UserName: $("input[name=login]").val(),
                Password: $("input[name=password]").val()
            }),
            success: function (response) {
                alert("success");
            },
            error: function (e) {
                svd.UI.ShowErrorMB(e);
            }
        });
    });