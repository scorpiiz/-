$(function() {
    document.body.className = localStorage.getItem("config-skin");
    $("[data-toggle='tooltip']").tooltip && $("[data-toggle='tooltip']").tooltip()
});
$.reload = function() {
    location.reload();
    return !1
};
$.loading = function(a, b) {
    var c = top.$("#loadingPage"),
        d = c.find(".loading-content");
    a ? c.show() : void 0 == d.attr("istableloading") && c.hide();
    b ? d.html(b) : d.html("\u6570\u636e\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u2026");
    d.css("left", (top.$("body").width() - d.width()) / 2 - 50);
    d.css("top", (top.$("body").height() - d.height()) / 2)
};
$.request = function(a) {
    var b = location.search.slice(1).split("&");
    alert(d[1]);
    for (var c = 0; c < b.length; c++) {
        var d = b[c].split("=");
        if (d[0] == a)
            if ("undefined" == unescape(d[1])) break;
            else return unescape(d[1])
    }
    return ""
};
$.currentWindow = function() {
    var a = top.$(".main_iframe:visible").attr("id");
    return top.frames[a]
};
$.browser = function() {
    var a = navigator.userAgent,
        b = -1 < a.indexOf("Opera");
    if (b) return "Opera";
    if (-1 < a.indexOf("Firefox")) return "FF";
    if (-1 < a.indexOf("Chrome")) return -1 < window.navigator.webkitPersistentStorage.toString().indexOf("DeprecatedStorageQuota") ? "Chrome" : "360";
    if (-1 < a.indexOf("Safari")) return "Safari";
    if (-1 < a.indexOf("compatible") && -1 < a.indexOf("MSIE") && !b) return "IE"
};
$.download = function(a, b, c) {
    if (a && b) {
        b = "string" == typeof b ? b : jQuery.param(b);
        var d = "";
        $.each(b.split("&"), function() {
            var a = this.split("=");
            d += '<input type="hidden" name="' + a[0] + '" value="' + a[1] + '" />'
        });
        $('<form action="' + a + '" method="' + (c || "post") + '">' + d + "</form>").appendTo("body").submit().remove()
    }
};
$.modalOpen = function(a) {
    a = $.extend({
        id: null,
        title: "\u7cfb\u7edf\u7a97\u53e3",
        width: "100px",
        height: "100px",
        url: "",
        shade: .3,
        btn: ["\u786e\u8ba4", "\u5173\u95ed"],
        btnclass: ["btn btn-primary", "btn btn-danger"],
        callBack: null
    }, a);
    var b = top.$(window).width() > parseInt(a.width.replace("px", "")) ? a.width : top.$(window).width() + "px",
        c = top.$(window).height() > parseInt(a.height.replace("px", "")) ? a.height : top.$(window).height() + "px";
    top.layer.open({
        id: a.id,
        type: 2,
        shade: a.shade,
        title: a.title,
        fix: !1,
        area: [b, c],
        content: a.url,
        btn: a.btn,
        btnclass: a.btnclass,
        yes: function() {
            a.callBack(a.id)
        },
        cancel: function() {
            return !0
        }
    })
};
$.modalConfirm = function(a, b) {
    top.layer.confirm(a, {
        icon: "fa-exclamation-circle",
        title: "\u7cfb\u7edf\u63d0\u793a",
        btn: ["\u786e\u8ba4", "\u53d6\u6d88"],
        btnclass: ["btn btn-primary", "btn btn-danger"]
    }, function() {
        b(!0)
    }, function() {
        b(!1)
    })
};
$.modalAlert = function(a, b) {
    var c = "";
    "success" == b && (c = "fa-check-circle");
    "error" == b && (c = "fa-times-circle");
    "warning" == b && (c = "fa-exclamation-circle");
    top.layer.alert(a, {
        icon: c,
        title: "\u7cfb\u7edf\u63d0\u793a",
        btn: ["\u786e\u8ba4"],
        btnclass: ["btn btn-primary"]
    })
};
$.modalMsg = function(a, b) {
    if (void 0 != b) {
        var c = "";
        "success" == b && (c = "fa-check-circle");
        "error" == b && (c = "fa-times-circle");
        "warning" == b && (c = "fa-exclamation-circle");
        top.layer.msg(a, {
            icon: c,
            time: 4E3,
            shift: 5
        });
        top.$(".layui-layer-msg").find("i." + c).parents(".layui-layer-msg").addClass("layui-layer-msg-" + b)
    } else top.layer.msg(a)
};
$.modalClose = function() {
    var a = top.layer.getFrameIndex(window.name),
        b = top.$("#layui-layer" + a).find(".layui-layer-btn").find("#IsdialogClose"),
        c = b.is(":checked");
    0 == b.length && (c = !0);
    c ? top.layer.close(a) : location.reload()
};
$.submitForm = function(a) {
    a = $.extend({
        url: "",
        param: [],
        loading: "\u6b63\u5728\u63d0\u4ea4\u6570\u636e...",
        success: null,
        close: !0
    }, a);
    $.loading(!0, a.loading);
    window.setTimeout(function() {
        0 < $("[name=__RequestVerificationToken]").length && (a.param.__RequestVerificationToken = $("[name=__RequestVerificationToken]").val());
        $.ajax({
            url: a.url,
            data: a.param,
            type: "post",
            dataType: "json",
            traditional: !0,
            success: function(b) {
                "success" == b.state ? (a.success(b), $.modalMsg(b.message, b.state), 1 == a.close && $.modalClose()) : $.modalAlert(b.message,
                    b.state)
            },
            error: function(a, c, d) {
                $.loading(!1);
                $.modalMsg(d, "error")
            },
            beforeSend: function() {
                $.loading(!0, a.loading)
            },
            complete: function() {
                $.loading(!1)
            }
        })
    }, 500)
};
$.deleteForm = function(a) {
    a = $.extend({
        prompt: "\u6ce8\uff1a\u60a8\u786e\u5b9a\u8981\u5220\u9664\u8be5\u9879\u6570\u636e\u5417\uff1f",
        url: "",
        param: [],
        loading: "\u6b63\u5728\u5220\u9664\u6570\u636e...",
        success: null,
        close: !0
    }, a);
    0 < $("[name=__RequestVerificationToken]").length && (a.param.__RequestVerificationToken = $("[name=__RequestVerificationToken]").val());
    $.modalConfirm(a.prompt, function(b) {
        b && ($.loading(!0, a.loading), window.setTimeout(function() {
            $.ajax({
                url: a.url,
                data: a.param,
                type: "post",
                dataType: "json",
                success: function(b) {
                    "success" == b.state ? (a.success(b), $.modalMsg(b.message, b.state)) : $.modalAlert(b.message, b.state)
                },
                error: function(a, b, e) {
                    $.loading(!1);
                    $.modalMsg(e, "error")
                },
                beforeSend: function() {
                    $.loading(!0, a.loading)
                },
                complete: function() {
                    $.loading(!1)
                }
            })
        }, 500))
    })
};
$.jsonWhere = function(a, b) {
    if (null != b) {
        var c = [];
        $(a).each(function(a, e) {
            b(e) && c.push(e)
        });
        return c
    }
};
$.fn.jqGridRowValue = function() {
    var a = $(this),
        b = a.jqGrid("getGridParam", "selarrrow");
    if ("" != b) {
        for (var c = [], d = b.length, e = 0; e < d; e++) {
            var f = a.jqGrid("getRowData", b[e]);
            c.push(f)
        }
        return c
    }
    return a.jqGrid("getRowData", a.jqGrid("getGridParam", "selrow"))
};
$.fn.formValid = function() {
    return $(this).valid({
        errorPlacement: function(a, b) {
            b.parents(".formValue").addClass("has-error");
            b.parents(".has-error").find("i.error").remove();
            b.parents(".has-error").append('<i class="form-control-feedback fa fa-exclamation-circle error" data-placement="left" data-toggle="tooltip" title="' + a + '"></i>');
            $("[data-toggle='tooltip']").tooltip();
            b.parents(".input-group").hasClass("input-group") && b.parents(".has-error").find("i.error").css("right", "33px")
        },
        success: function(a) {
            a.parents(".has-error").find("i.error").remove();
            a.parent().removeClass("has-error")
        }
    })
};
$.fn.formSerialize = function(a) {
    var b = $(this);
    if (a) {
        for (var c in a) {
            var d = b.find("#" + c),
                e = $.trim(a[c]).replace(/&nbsp;/g, ""),
                f = d.attr("type");
            d.hasClass("select2-hidden-accessible") && (f = "select");
            switch (f) {
                case "checkbox":
                    "true" == e ? d.attr("checked", "checked") : d.removeAttr("checked");
                    break;
                case "select":
                    d.val(e).trigger("change");
                    break;
                default:
                    d.val(e)
            }
        }
        return !1
    }
    var g = {};
    b.find("input,select,textarea").each(function(a) {
        var b = $(this);
        a = b.attr("id");
        switch (b.attr("type")) {
            case "checkbox":
                g[a] = b.is(":checked");
                break;
            default:
                b = "" == b.val() ? "&nbsp;" : b.val(), $.request("keyValue") || (b = b.replace(/&nbsp;/g, "")), g[a] = b
        }
    });
    0 < $("[name=__RequestVerificationToken]").length && (g.__RequestVerificationToken = $("[name=__RequestVerificationToken]").val());
    return g
};
$.fn.bindSelect = function(a) {
    a = $.extend({
        id: "id",
        text: "text",
        search: !1,
        url: "",
        param: [],
        change: null,
        data: null
    }, a);
    var b = $(this);
    null != a.data && bindSelectData(a, b);
    "" != a.url ? $.ajax({
        url: a.url,
        data: a.param,
        dataType: "json",
        async: !1,
        success: function(c) {
            a.data = c;
            bindSelectData(a, b)
        }
    }) : b.select2({
        minimumResultsForSearch: -1
    })
};

function bindSelectData(a, b) {
    $.each(a.data, function(c) {
        b.append($("<option></option>").val(a.data[c][a.id]).html(a.data[c][a.text]))
    });
    b.select2({
        minimumResultsForSearch: 1 == a.search ? 0 : -1
    });
    b.on("change", function(c) {
        null != a.change && a.change(a.data[$(this).find("option:selected").index()]);
        $("#select2-" + b.attr("id") + "-container").html($(this).find("option:selected").text().replace(/\u3000\u3000/g, ""))
    })
}
$.fn.dataGrid = function(a) {
    a = $.extend({
        datatype: "json",
        autowidth: !0,
        rownumbers: !0,
        shrinkToFit: !1,
        gridview: !0,
        add: !1,
        edit: !1,
        del: !1
    }, a);
    var b = $(this);
    a.onSelectRow = function(a) {
        a = $(this).jqGrid("getGridParam", "selrow").length;
        var b = $(".operate");
        0 < a ? b.animate({
            left: 0
        }, 200) : b.animate({
            left: "-100.1%"
        }, 200);
        b.find(".close").click(function() {
            b.animate({
                left: "-100.1%"
            }, 200)
        })
    };
    b.jqGrid(a);
    a.add && b.navButtonAdd("#gridPager", {
        caption: "Add",
        buttonicon: "ui-icon-add",
        onClickButton: function() {
            alert("Adding Row")
        },
        position: "last"
    })
};

function ReSetModelId(a) {
    if (a && 0 < a.length) {
        for (var b = [], c = 0; c < a.length; c++) a[c].id = c, b.push(a[c]);
        return b
    }
    return a
}

function compare(a) {
    return function(b, c) {
        b = b[a];
        c = c[a];
        isNaN(Number(b)) || isNaN(Number(c)) || (b = Number(b), c = Number(c));
        return b < c ? -1 : b > c ? 1 : 0
    }
}

function GetToken(a) {
    0 < $("[name=__RequestVerificationToken]").length && (a.__RequestVerificationToken = $("[name=__RequestVerificationToken]").val())
}
String.prototype.MyReplace = function(a, b) {
    return this.replace(new RegExp(a, "g"), b)
};