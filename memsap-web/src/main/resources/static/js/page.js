/**
 * 分页
 */
var _page;

//外部页面初始化分页时引用
function initPage(page) {
    _page = page;
    $("input[name='pn']").val(_page.pn);
    $("input[name='perPageNum']").val(_page.perPageNum);
    var pageHtml = "";
    if (page.totalCount > 0) {
        pageHtml =
            "<div class='pull-right'>" +
            "   <nav aria-label='Page navigation'>" +
            "   <ul class='pagination'  id='pagination'> " +
            ' <li class="first"><a onclick="changePageNum(1)"><span  class="icon icon-verticleright"> </span></a></li>' +
            "     <li class='pre'>";
        if (page.pn > 1) { //向前一页
            pageHtml += "       <a href='javascript:void(0)' onclick='changePageNum(" + (page.pn - 1) + ")' aria-label='Previous'>";
        } else {
            pageHtml += "       <a href='javascript:void(0)'  aria-label='Previous'>";
        }
        pageHtml += "             <span  class='icon icon-pre'> </span> " +
            "        </a>" +
            "    </li>";
        //总页数大于1页的情况，固定1
        if (page.pn == 1) {
            pageHtml += "<li class='pagination-item sel'><a href='javascript:void(0)' onclick='changePageNum(" + (1) + ")'>" + (1) + "</a></li>";
        } else {
            pageHtml += "<li class='pagination-item '><a href='javascript:void(0)' onclick='changePageNum(" + (1) + ")'>" + (1) + "</a></li>";
        }

        //从总页数-2/2开始
        var i = parseInt((page.totalPage - 2) / 2);
        if (i == 0) {
            i = 1;
        }
        var size = i + 5;
        if (page.totalPage - 1 <= 5) {
            size = page.totalPage - 1;
        }
        if (page.pn > 5 && page.pn < page.totalPage - 1) {
            if ((page.pn + 2) < page.totalPage) {
                size = page.pn + 2;
                i = page.pn - 3;
            } else {
                size = page.totalPage - 1;
                i = page.pn - 3;
            }
        } else if (page.pn > 1 && page.pn < 6 && page.pn < page.totalPage - 1) {
            i = 1;
            size = 5;
            if (page.totalPage - 1 <= 5) {
                size = page.totalPage - 1;
            }
        } else if (page.pn >= page.totalPage - 1) {
            if (page.pn > 5) {
                i = page.pn - 5;
            } else {
                i = 1;
            }

            size = page.pn;
        }
        if (i > 2) {
            pageHtml += "<li class='pagination-jump-next'><a href='javascript:void(0)'  onclick='first5(" + page.pn + ")'  title ='向前5页' ></a></li>";
        }
        if (i == 2) {
            i = 1;
            size = page.totalPage;
        }
        for (i; i < size; i++) {
            if (page.pn == i + 1) {
                pageHtml += "<li class='pagination-item sel'><a href='javascript:void(0)' onclick='changePageNum(" + (i + 1) + ")'>" + (i + 1) + "</a></li>";
            } else {
                pageHtml += "<li class='pagination-item'><a href='javascript:void(0)' onclick='changePageNum(" + (i + 1) + ")'>" + (i + 1) + "</a></li>";
            }
            if (i == size - 1 && (page.totalPage > size + 1)) {
                pageHtml += "<li class='pagination-jump-next next'><a href='javascript:void(0)' onclick='next5(" + size + "," + page.pn + ")'  title ='向后5页'></a></li>";
            }
        }

        if (page.totalPage > size) {
            pageHtml += "<li class='pagination-item'><a href='javascript:void(0)' onclick='changePageNum(" + (page.totalPage) + ")' >" + (page.totalPage) + "</a></li>";
        }
        pageHtml += "    <li class='next'>";
        if (page.pn + 1 <= page.totalPage) {
            pageHtml += "       <a href='javascript:void(0)' onclick='changePageNum(" + (page.pn + 1) + ")' aria-label='Next'>";
        } else {
            pageHtml += "       <a href='javascript:void(0)' aria-label='Next' >";
        }
        pageHtml += "         <span  class='icon icon-next'> </span>" +
            "       </a>" +
            "    </li>" +
            '<li class="last"><a  onclick="changePageNum(' + page.totalPage + ')"><span class="icon icon-verticleleft"></span></a></li>' +
            "   </ul>" +
            "<div class='pagination-each'>" +
            "  <span>每页</span>" +
            "  <div class='form-group'>" +
            "      <div class='select form-control input-sm '>" +
            "         <input type='hidden' class='select-ivalue' id='iptPageSize' value='" + page.pageSize + "' onchange='changePageNum(" + page.pn + ")'>" +
            "         <input type='hidden' class='select-itext'>" +
            "          <div class='select-toggle '>" +
            "              <span class='select-text'>" + page.pageSize + "</span>" +
            "              <span class='icon icon-down'></span>" +
            "          </div>" +
            "      <div class='select-option  '>" +
            "          <ul>" +
            "             <li value='5'>5</li>" +
            "             <li value='10'>10</li>" +
            "             <li value='15'>15</li>" +
            "             <li value='20'>20</li>" +
            "          </ul>" +
            "      </div>" +
            "       </div>" +
            "    </div>" +
            "<span>条</span>" +
            "</div>" +
            "<div class='pagination-sum'>" +
            "<span>共</span>" +
            "<span id='totalCount'>" + page.totalCount + "</span>" +
            "<span>条</span>" +
            "</div> " +
            "<div class='pagination-jump'>" +
            "<span>跳至</span>" +
            " <div class='form-group  '>" +
            "    <input type='text' value=" + page.pn + "  id='pageNum' onblur='pageNumblur(" + page.totalPage + ")' class='form-control input-sm'>" +
            " </div>" +
            "<span>页</span>" +
            " </div>" +
            "</nav>" +
            " </div>";
    }
    console.log(pageHtml)
    $(".table-action").append(pageHtml);
}

function pageNumblur(totalPage) {
    if ($("#pageNum").val() > totalPage) {
        layer.alert("最多只有" + totalPage + "页" + ",你输入了" + $("#pageNum").val() + "页");
        $("#pageNum").val(1);
        return;
    }
    changePageNum($("#pageNum").val());
}

//1.正则验证
//2.如果页数非空，给跳转方法的参数赋值
function inputPageNum(element) {
    $(element).val($(element).val().replace(/\D/g, ''));
    if ($(element).val().length > 0) {
        $(".pageNumJump").html("<a onclick='changePageNum(" + $(element).val() + ")' class='page-jump btn-text'><i class='i-refresh'></i>跳转</a>");
    }
}

function first5(pageNum, totalPage) {
    changePageNum(pageNum-5);
}

function next5(pageNum, totalPage) {
    changePageNum(totalPage + 5);
}


//页数变换
function changePageNum(pn) {
    var form = $("form");
    /* var pageNumInput = document.createElement("input");
     pageNumInput.style.display = "none";
     pageNumInput.name = "pn";
     pageNumInput.value = pn;
     form.append(pageNumInput);*/
    var perPageNum = parseInt($("#iptPageSize").val());
    var totalCount = parseInt($("#totalCount").text());
    if (pn * perPageNum > totalCount) {
        pn = (totalCount % perPageNum > 0) ? (totalCount / perPageNum + 1) : (totalCount / perPageNum);
    }
    $("input[name='pn']").val(parseInt(pn));
    $("input[name='perPageNum']").val(perPageNum);
    // form.append(pageSizeInput);
    form.submit();
}
