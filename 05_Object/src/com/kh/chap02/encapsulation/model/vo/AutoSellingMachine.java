package com.kh.chap02.encapsulation.model.vo;


// 필드부, 생성자부, 메소드부 
public class AutoSellingMachine { // 단 한 개의 제품을 파는 자판기
	// 필드(Field)부
	/*
	 * 값을 담는 부분
	 * 
	 * 필드 == 멤버변수
	 * 
	 * 객체들이 가져야할 공통적인 속성을 기술해 놓는 것
	 * 
	 * 접근제한자 자료형 필드식별자;
	 */
	
	/*
	 * + 업무에 대한 도메인 지식☆★☆★☆★☆★☆★☆
	 * 
	 * 주말 숙제 꼭 해오기!!!! : 어떤 분야 개발자 할지 정해오기, 관련분야 지식, 자격증
	 */
	// 자판기 == 제품이름, 제품가격, 수량
	private String name;
	private int price;
	private int amount;
	
	/*
	public void hi() {
		System.out.println("하이");
	}
	*/
	// Dependency(의존) 관계 정말정말중요 ☆
	private void checkAmount() {
		System.out.println("재고는 총 " + amount + "개 입니다.");
	}
	private void sellingProduct() {
		amount -= 1;
	}
	private void insert() {
		amount += 3;
	}
	
	public void openMachine() {
		checkAmount();
		insert();
		sellingProduct();
		checkAmount();
	}

	
	
	
	
	
	// 객체의 속성 값을 기록 및 수정하는 기능의 메소드 : setter()
	/*
	 * VO -> ☆★setter메소드를 구현하지 않음★☆
	 * DTO -> setter를 구현해서
	 * 
	 * DTO를 배우려면 짧게잡아도 한 달 반정도는 더 수업을 해야함
	 * 그래서 DTO배울 때 까지만 VO에 setter를 구현해서 사용하겠음
	 * 
	 * setter만들기 규칙
	 * 
	 * 1. setter메소드는 외부에서 접근이 가능해야 하기 때문에 접근제한자 public을 이용
	 * 2. set필드명으로 식별자를 작성하며 낙타봉표기법(camelCase)를 꼭 지키도록한다!!!
	 */
	
	// ☆ 하나의 메소드는 하나의 기능만을 수행해야한다. ★
	
	
	// price필드 값을 set할 수 있는 메소드 구현
	public void setPrice(int price) {
						// parameter, 매개변수
						// 매개변수는 메소드 호출 시 초기화가 강제됨 ※ 암기
		// System.out.println(asm);
		// System.out.println(price);
		// price = price;
		// Scope안에서는 해당 영역안에 있는 지역변수가 식별자 우선권을 가진다.
		// System.out.println("내 주소가 뭐지 : " + this);
		// this : 해당 객체의 주소값을 가리키는 역할
		if(price > 0) {
			this.price = price;
		} else {
			System.out.println("가격은 0이하일 수 없습니다.");
		}
	}// 메모리 구조의 대한 이해!!!!!

	public int 두부사오기(int 금액) {
		System.out.println("엄마 한테 받은 돈 : " + 금액);
		System.out.println("두부사오기");
		금액 -= 1000;
		System.out.println("두부를 사고 남는 돈 : " + 금액);
		return 금액;
	}
	// name 필드를 기록 및 수정할 수 있는 메소드
	public void setName(String name) {
		this.name = name;
	}
	// amount 필드를 기록 및 수정할 수 있는 메소드
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/*
	 ※ 관례 위반 : 두 개 이상의 필드값을 변경하는 메소드 이름에 set이 붙으면 안됨!!!
	public void setPriceAndAmount(int price, int amount) {
		setPrice(price);
		setAmount(amount);
	}
	*/
	
	// 데이터를 반환해주는 기능의 메소드 : getter() ->> 꼭 있어야함!!!!!!!!!!!!!!!!!!!
	/*
	 * 규칙!
	 * 
	 *  1. getter()는 접근제한자 public을 사용한다.
	 *  2. get필드명으로 짓되, 낙타봉표기법(camelCase)를 사용한다.  
	 *  3. VO패키지안에 존재하는 클래스라면 getter는 무조건 꼭 절대로 
	 *  다 만드세요!!!!!!!!!!!!!!!!!!!!
	 */
	
	// 메소드를 호출한 곳으로 name필드 값을 돌려주고 싶음
	public String getName() {
		return name;
	}
	
	// 개수를 반환해주는 메소드
	public int getAmount() {
		return amount;
	}
	
	// 가격을 반환해주는 메소드
	public int getPrice() {
		return price;
	}
	
	
	// 필드들의 접근제한자를 private으로 변경한 뒤
	// 각각의 필드들에 대한 getter() / setter()를 구현하면
	// 캡슐화가 끝났다!
	/*
	 * 1. 값을 숨긴다 => 필드의 접근제한자를 private으로 선언 
	 * 
	 * 2. 메소드를 통해 필드에 접근할 수 있게 만든다 => getter() / setter() 구현
	 * 
	 * 데이터를 숨김 => 객체간의 결합도가 낮아짐 => 책임을 분리시킴 
	 */
	/*
	public void a() {
		System.out.println("나는 a당");
		int b = b();
		System.out.println("b의 값은? " + b);
	}
	public int b() {
		System.out.println("나는 b당");
		int c = c();
		System.out.println("c를 불렀땅");
		return c;
	}
	public int c() {
		System.out.println("나는 C당");
		return 1;
	}
	public void d() {
		e();
	}
	public void e() {
		d();
	}
	*/
	
	private String color;
	
	public String info() {
		String info = "자판기 = [제품명 : " + name + ", 가격 : " + price + ", 재고 : "
					+ amount + "색상 : " + color + "]";
		return info;
	}
	

}
