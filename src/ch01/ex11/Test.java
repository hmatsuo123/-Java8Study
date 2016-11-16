package ch01.ex11;

public class Test {

	class AbstractI_AbstractJ implements AbstractI, AbstractJ {

		// コンパイルエラー：型 Test.AbstractI_AbstractJ は継承された抽象メソッド AbstractJ.f() を実装する必要があります
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class AbstractI_DefaultJ implements AbstractI, DefaultJ {

		// コンパイルエラー：The default method f() inherited from DefaultJ conflicts with another method inherited from AbstractI
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class AbstractI_StaticJ implements AbstractI, StaticJ {

		// コンパイルエラー：型 Test.AbstractI_StaticJ は継承された抽象メソッド AbstractI.f() を実装する必要があります
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class DefaultI_StaticJ implements DefaultI, StaticJ {

		// コンパイルエラーにならない
	}

	class DefaultI_DefaultJ implements DefaultI, DefaultJ {

		// コンパイルエラー：Duplicate default methods named f with the parameters () and () are inherited from the types DefaultJ and DefaultI
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class StaticI_StaticJ implements StaticI, StaticJ {

		// コンパイルエラーにならない

		// コンパイルエラーになり、以下のようにオーバーライドできない：Duplicate default methods named f with the parameters () and () are inherited from the types DefaultJ and DefaultI
		/*@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}*/

	}

	class S_AbstractI extends S implements AbstractI {

		// コンパイルエラー：継承メソッド S.f() は AbstractI 内の public 抽象メソッドを隠蔽できません
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class S_DefaultI extends S implements DefaultI {

		// コンパイルエラー：継承メソッド S.f() は DefaultI 内の public 抽象メソッドを隠蔽できません
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

	class S_StaticI extends S implements StaticI {

		// コンパイルエラーにならない

		// 以下のようにオーバーライドもできる
		@Override
		public void f() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}
}
