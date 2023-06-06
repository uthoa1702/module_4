/**
 *
 *
 * @param {*} blogs: Danh sách sản phẩm cần được render lên browser
 * @param {*} append: nếu là true thì dữ liệu sản phẩm sẽ được append tiếp vào danh sách sản phẩm hiện tại,
 *                     false sẽ ngược lại
 */
function renderBlogs(blogs, append) {
  let elements = "";
  for (let blog of blogs) {
    // Ở đây anh đang sử dụng `` để thao tác với chuỗi multiple lines
    elements += `
                    <div class="card col-sm-3">
                        <img src="${blog.thumbnail_url}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${blog.name}</h5>
                            
                        </div>
                    </div>
                `;
  }

  $("#listBlogs").html(elements);
}
/**
 *
 *
 * @param {*} nextPage
 */
function loadMore(nextPage) {
  loadBlogs(nextPage, true, $("#freeText").val());
}
/**
 * Mục đích dùng để kiểm tra điều kiện và render nút Load More
 *
 * @param {*} productPageData
 */
function renderLoadMoreButton(productPageData) {
  if (productPageData.number < productPageData.totalPages - 1) {
    $("#loadMoreContainer").html(
      `
               <button id="btnLoadMore" type="button" class="btn btn-secondary"
                    onclick="loadMore(${productPageData.number + 1})">
                    Load More
               </button>
        `
    );
  } else {
    /*
     * Nếu lấy hết page rồi thì xoá nút Load More, không cho hiển thị trên browser nữa.
     * Tránh người dùng thao tác bấm nút mà ko còn dữ liệu để lấy.
     */
    $("#btnLoadMore").remove();
  }
}

function onSearch() {
  const freeText = $("#freeText").val();
  loadBlogs(undefined, false, freeText);
}

/**
 *
 *
 * @param {*} page
 * @param {*} append
 */
function loadBlogs(page, append, freeText) {
  $.ajax({
    type: "GET", // HTTP Method
    url: `http://localhost:3000/blogs`, // URL
    headers: {
      "Content-Type": "application/json",
    },
    success: function (data) {
      // callback xử lý khi request thành công
      renderBlogs(data);
    },
    error: function (error) {
      // callback xử lý khi request thất bại
      console.log(error);
    },
  });
}

/**
 * Mục đích của đoạn code này là chờ cho document sẵn sàng rồi mới thực hiện phần code bên trong callback
 * (lấy dữ liệu sản phẩm)
 *
 */
$(document).ready(function () {
  loadBlogs();
});
