package oop4;

public class ProductService {

	Product[] db = new Product[20];
	int position = 0;
	

	// 배열에 저장된 모든 상품정보를 출력한다.
	void printAllProducts() {
		System.out.println("=================================================================");
		System.out.println("상품이름\t제조회사\t카테고리\t판매가격\t할인비율\t재고량\t절판여부");
		System.out.println("=================================================================");
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			System.out.print(product.name + "\t");
			System.out.print(product.maker + "\t");
			System.out.print(product.category + "\t");
			System.out.print(product.price + "\t");
			System.out.print(product.discountRate + "\t");
			System.out.print(product.stock + "\t");
			System.out.println(product.isSoldOut + "\t");
		}
		System.out.println("=================================================================");
	}
	
	// 상품객체(새 상품, 이월상품)를 전달받아서 배열에 저장한다.
	void insertProduct(Product product) {
		db[position] = product;
		position++;
	}
	
	// 상품명과 입고량을 전달받아서 이미 배열에 저장된 상품의 재고량을 증가시킨다.
	void addProductStock(String name, int amount) {
		Product foundProduct = findByProductName(name);
		
		if(foundProduct != null) {
			foundProduct.stock += amount;
			
			if(foundProduct.stock > 0) {
				foundProduct.isSoldOut = false;
			}
		} else {
			System.out.println("입력한 상품명과 일치하는 정보를 찾을 수 없습니다.");
		}
		
	}
	
	// 상품명과 출고량을 전달받아서 배열에서 해당 상품을 찾아서 재고량을 감소시킨다.
	// 단, 재고량보다 출고량이 많은 경우 오류메세지를 표시한다.
	// 단, 재고량이 0이 되면 해당 상품의 절판여부를 true로 설정한다.
	void exportProduct(String name, int amount) {
		Product foundProduct = findByProductName(name);
		
		if(foundProduct != null) {
			if(amount > foundProduct.stock) {
				System.out.println("재고가 부족합니다.");
			} else {
				foundProduct.stock -= amount;
				
				if(foundProduct.stock == 0) {
					foundProduct.isSoldOut = true;
				}
			}
			
		} else {
			System.out.println("입력한 상품명과 일치하는 정보를 찾을 수 없습니다.");
		}
	}
	
	// 상품명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void printProductsByName(String name) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			boolean isFound = false;
			if(name.equals(product.name)) {
				isFound = true;
			}
			if(isFound) {
				product.display();
			}
		}	
	}

	// 제조사명을 전달받아서 배열에서 제조사명이 일치하는 상품정보를 출력한다.
	void printProductsByMaker(String maker) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			boolean isFound = false;
			if(maker.equals(product.maker)) {
				isFound = true;
			}
			if(isFound) {
				product.display();
			}
		}
	}

	// 카테고리명을 전달받아서 배열에서 카테고리명이 일치하는 상품정보를 출력한다.
	void printProductsByCategory(String category) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			boolean isFound = false;
			if(category.equals(product.category)) {
				isFound = true;
			}
			if(isFound) {
				product.display();
			}
		}
	}

	// 최저가격과 최고가격을 전달받아서 배열에서 해당 가격범위에 속하는 상품정보를 출력한다.
	void printProductsByPrice(int minPrice, int maxPrice) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			boolean isFound = false;
			if(product.price >= minPrice && product.price <= maxPrice) {
				isFound = true;
			}
			if(isFound) {
				product.display();
			}
		}
	}

	
	Product findByProductName(String name) {
		Product result = null;
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				result = product;
				break;
			}
		}
		return result;
	}
}