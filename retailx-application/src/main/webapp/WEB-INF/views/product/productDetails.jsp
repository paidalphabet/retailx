<script type="text/javascript">
	function generateCode(){
		httpGet("/product/code/", 'code');
	}

	$(document).ready(function(){
       generateCode();
    });
</script>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<form action = "/data/product/" id = "add-product">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<h4>Enter Product Details</h4>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-4">
									<div class="form-group">
										<label for="type">Type</label>
										<select name="type" class="form-control tip select2 select2-hidden-accessible" id="type" required="required" style="width:100%;" data-fv-field="type" tabindex="-1" aria-hidden="true">
											<option value="standard" selected="selected">Standard</option>
											<option value="combo">Combo</option>
											<option value="service">Service</option>
										</select>
									</div>
									<div class="form-group">
										<label for="name">Name</label>
										<input type="text" name="name" value="" class="form-control tip" id="name" required="required" data-fv-field="name">
										</div>
										<div class="form-group st">
											<label for="cost">Cost</label>
											<input type="text" name="cost" value="" class="form-control tip" id="cost">
											</div>
											<div class="form-group">
												<label for="tax_method">Tax Method</label>
												<select name="taxMethod" class="form-control tip select2 select2-hidden-accessible" id="tax_method" required="required" style="width:100%;" data-fv-field="tax_method" tabindex="-1" aria-hidden="true">
													<option value="Inclusive">Inclusive</option>
													<option value="Exclusive">Exclusive</option>
												</select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<label for="category">Category</label>
												<select name="category" class="form-control select2 tip select2-hidden-accessible" id="category" required="required" style="width:100%;" data-fv-field="category" tabindex="-1" aria-hidden="true">
													<option value="" selected="selected">Select Category</option>
													<option value="1">General</option>
												</select>
											</div>
											<div class="form-group">
												<label for="code">Code</label>
												<input type="text" name="code" value="" class="form-control tip" id="code" required="required" data-fv-field="code">
												</div>
												<div class="form-group">
													<label for="price">Price</label>
													<input type="text" name="price" value="" class="form-control tip" id="price" required="required" data-fv-field="price">
														<small class="help-block" data-fv-validator="notEmpty" data-fv-for="price" data-fv-result="NOT_VALIDATED" style="display: none;">Please enter a value</small>
													</div>
													<div class="form-group">
														<label for="product_tax">Product Tax</label>
														<input type="text" name="productTax" value="0" class="form-control tip" id="product_tax" required="required" data-fv-field="product_tax">
														</div>
													</div>
													<div class="col-sm-2">
														<img src="img/product.png" class="card-img"/>
														<div class="form-group">
															<label for="image">Image</label>
															<input type="file" name="userfile" id="image" tabindex="" style="">
																<div></div>
															</div>
														</div>
													</div>
												<div class="row">
													<div class="col-sm-2">
														<div class="form-group">
															<button class="btn btn-success" onclick="submitForm('add-product', '/data/product/', event)">Save</button>
														</div>
													</div>
												</div>
							
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>