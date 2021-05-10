package shop;

public enum Type {
	CLASSICAL {
		@Override
		public String toString() {
			return "Classical";
		}
	}

	,
	ELECTRIC {
		@Override
		public String toString() {
			return "Electric";
		}
	}

	,
	ACOUSTIC {
		@Override
		public String toString() {
			return "Acoustic";
		}
	}

}
