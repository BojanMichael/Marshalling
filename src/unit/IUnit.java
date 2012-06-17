package unit;
public interface IUnit<U extends IUnit<? super U>> 
{
	public double getFactorTo(U unit);
	public double getFactorToSIUnit();
	public String getUnitLabel();
}
