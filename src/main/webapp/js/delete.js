function delete1(a) {
    if (confirm('确实要删除该内容吗?')) {
        var val=$(a).attr("name");
        $.ajax({
            cache: false,
            type: "POST",
            url: "/delete",
            data: {studentId: val},
            async: false,
            success: function (data) {
                alert("数据删除成功！")
                location="/main.jsp"
            },
        })
    }
}
