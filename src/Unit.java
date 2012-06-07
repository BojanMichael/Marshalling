public interface Unit<U extends Unit<? super U>> {
	//And what if we want to convert Fahrenheit? (Closure)
	public double getFactorTo(U unit);

	public double getFactorToSIUnit();

	public String getUnitLabel();
}
