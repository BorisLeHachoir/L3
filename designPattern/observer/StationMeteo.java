import java.util.*;

abstract class Observer
{
	protected float _temp;
	protected float _pression;
	protected float _humi;

	abstract void actualiser(float temp, float pression, float humi);
}

class ObsActu extends Observer
{
	public void actualiser(float temp, float pression, float humi)
	{
		_temp = temp;
		_pression = pression;
		_humi = humi;
		System.out.println("Obsactu: " + _temp + " " + _pression + " " + _humi);
	}
}

class ObsMoy extends Observer
{

	public ObsMoy()
	{
		_temp = _pression = _humi = 0;
	}

	public void actualiser(float temp, float pression, float humi)
	{
		System.out.println("ObsMoy: " + (_temp + temp)/2.0 + " " + (_pression + pression)/2.0 + " " + (_humi + humi)/2.0);
		_temp = temp;
		_pression = pression;
		_humi = humi;
	}
}

class Sujet
{
	//donnée
	private float _temp;
	private float _pression;
	private float _humi;
	private ArrayList<Observer> _obs;

	public Sujet(float temp, float pression, float humi)
	{
		_temp = temp;
		_pression = pression;
		_humi = humi;
		_obs = new ArrayList<Observer>();
	}

	public void addObs(Observer o)
	{
		_obs.add(o);
		o.actualiser(_temp,_pression,_humi);
	}

	public void delObs(Observer o)
	{
		_obs.remove(o);
	}

	public void setData(float temp, float pression, float humi)
	{
		_temp = temp;
		_pression = pression;
		_humi = humi;
		notifierObs(); 
	}

	protected void notifierObs()
	{
		for(Observer o: _obs){
			o.actualiser(_temp,_pression,_humi);
		}
	}
}

class StationMeteo
{
	public static void main(String [ ] args)
	{
		Sujet stationMeteo = new Sujet(10,1024,30);
		ObsActu oa = new ObsActu();
		ObsMoy om = new ObsMoy();
		stationMeteo.addObs(oa);
		stationMeteo.addObs(om);
		stationMeteo.setData(5,1000,60);
		stationMeteo.setData(12,1050,50);
		stationMeteo.setData(-15,900,(float)38.2);
		stationMeteo.setData(25,600,99);
	}
}