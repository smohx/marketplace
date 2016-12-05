<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/${sessionScope.image}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionScope.name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-cube"></i> <span>Manage Products</span> 
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="addProduct" ><i class="fa fa-circle-o"></i> Add New Product</a></li>
            <li><a href="productList" ><i class="fa fa-circle-o"></i> View/Modify Products</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-cube"></i>
            <span>Manage Categories</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="addCategory"><i class="fa fa-circle-o"></i> Add New Category</a></li>
            <li><a href="categoryList"><i class="fa fa-circle-o"></i> View/Modify Categories</a></li>
            </ul>
        </li> 
      </ul>
    </section>
  </aside>
	