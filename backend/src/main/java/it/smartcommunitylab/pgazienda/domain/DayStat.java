/*******************************************************************************
 * Copyright 2015 Fondazione Bruno Kessler
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/

package it.smartcommunitylab.pgazienda.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import it.smartcommunitylab.pgazienda.domain.Constants.MEAN;

/**
 * @author raman
 *
 */
public class DayStat {

	@Id
	private String id;
	
	private String campaign, playerId, date, month, company;
	
	private Double co2saved;
	private Integer trackCount;
	
	private Distances distances = new Distances();
	private Distances limitedDistances = null;
	private List<TrackingData> tracks = new LinkedList<>();
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the campaign
	 */
	public String getCampaign() {
		return campaign;
	}
	/**
	 * @param campaign the campaign to set
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	/**
	 * @return the playerId
	 */
	public String getPlayerId() {
		return playerId;
	}
	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the co2saved
	 */
	public Double getCo2saved() {
		if (co2saved == null || co2saved == 0) {
			co2saved = computeCO2();
		}
		
		return co2saved;
	}
	/**
	 * @return CO2 saved for bike/walk trips
	 */
	public Double computeCO2() {
		
		return distances == null ? 
				  0d 
				: ((distances.walk == null ? 0d : distances.walk) + (distances.bike == null ? 0d : distances.bike))*0.27/1000;
	}
	/**
	 * @param co2saved the co2saved to set
	 */
	public void setCo2saved(Double co2saved) {
		this.co2saved = co2saved;
	}
	/**
	 * @return the trackCount
	 */
	public Integer getTrackCount() {
		return trackCount;
	}
	/**
	 * @param trackCount the trackCount to set
	 */
	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}
	/**
	 * @return the distances
	 */
	public Distances getDistances() {
		return distances;
	}
	/**
	 * @param distances the distances to set
	 */
	public void setDistances(Distances distances) {
		this.distances = distances;
	}
	/**
	 * @return the tracks
	 */
	public List<TrackingData> getTracks() {
		return tracks;
	}
	/**
	 * @param tracks the tracks to set
	 */
	public void setTracks(List<TrackingData> tracks) {
		this.tracks = tracks;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the limitedDistances
	 */
	public Distances getLimitedDistances() {
		return limitedDistances;
	}
	/**
	 * @param limitedDistances the limitedDistances to set
	 */
	public void setLimitedDistances(Distances limitedDistances) {
		this.limitedDistances = limitedDistances;
	}




	public static class Distances {
		private Double bike, car, walk, bus, train, boat;

		/**
		 * @return the bike
		 */
		public Double getBike() {
			return bike;
		}

		/**
		 * @param bike the bike to set
		 */
		public void setBike(Double bike) {
			this.bike = bike;
		}

		/**
		 * @return the car
		 */
		public Double getCar() {
			return car;
		}

		/**
		 * @param car the car to set
		 */
		public void setCar(Double car) {
			this.car = car;
		}

		/**
		 * @return the walk
		 */
		public Double getWalk() {
			return walk;
		}

		/**
		 * @param walk the walk to set
		 */
		public void setWalk(Double walk) {
			this.walk = walk;
		}

		/**
		 * @return the bus
		 */
		public Double getBus() {
			return bus;
		}

		/**
		 * @param bus the bus to set
		 */
		public void setBus(Double bus) {
			this.bus = bus;
		}

		/**
		 * @return the train
		 */
		public Double getTrain() {
			return train;
		}

		/**
		 * @param train the train to set
		 */
		public void setTrain(Double train) {
			this.train = train;
		}

		/**
		 * @return the boat
		 */
		public Double getBoat() {
			return boat;
		}

		/**
		 * @param boat the boat to set
		 */
		public void setBoat(Double boat) {
			this.boat = boat;
		}

		public static Distances copy(Distances src) {
			Distances res = new Distances();
			res.setBike(src.getBike());
			res.setBoat(src.getBoat());
			res.setBus(src.getBus());
			res.setCar(src.getCar());
			res.setTrain(src.getTrain());
			res.setWalk(src.getWalk());
			return res;
		}
		
		/**
		 * @param collect
		 * @return
		 */
		public static Distances fromMap(Map<Object, Double> map) {
			Distances distances = new Distances();
			distances.setBike(((Number)map.getOrDefault("bike", 0d)).doubleValue());
			distances.setBoat(((Number)map.getOrDefault("boat", 0d)).doubleValue());
			distances.setBus(((Number)map.getOrDefault("bus", 0d)).doubleValue());
			distances.setTrain(((Number)map.getOrDefault("train", 0d)).doubleValue());
			distances.setCar(((Number)map.getOrDefault("car", 0d)).doubleValue());
			distances.setWalk(((Number)map.getOrDefault("walk", 0d)).doubleValue());
			return distances;
		}
		
		public Double meanValue(MEAN mean) {
			Double res = 0d;
			switch(mean) {
			case bike: res = getBike(); break;
			case boat: res = getBoat(); break;
			case bus: res = getBus(); break;
			case car: res = getCar(); break;
			case train: res = getTrain(); break;
			case walk: res = getWalk(); break;
			}
			if (res == null) res = 0d;
			return res;
		}
		public void updateValue(MEAN mean, Double value) {
			switch(mean) {
			case bike: setBike(value); break;
			case boat: setBoat(value); break;
			case bus: setBus(value); break;
			case car: setCar(value); break;
			case train: setTrain(value); break;
			case walk: setWalk(value); break;
			}
		}
		
		/**
		 * @param src
		 */
		public void mergeDistances(Distances src) {
			Distances res = this;
			if (res.getBike()==  null) res.setBike(0d);
			if (res.getBoat()==  null) res.setBoat(0d);
			if (res.getBus()==   null) res.setBus(0d);
			if (res.getCar()==   null) res.setCar(0d);
			if (res.getTrain()== null) res.setTrain(0d);
			if (res.getWalk()==  null) res.setWalk(0d);
			
			res.setBike(res.getBike()   + (src.getBike()  == null ? 0d : src.getBike()));
			res.setBoat(res.getBoat()   + (src.getBoat()  == null ? 0d : src.getBoat()));
			res.setBus(res.getBus()     + (src.getBus()   == null ? 0d : src.getBus()));
			res.setCar(res.getCar()     + (src.getCar()   == null ? 0d : src.getCar()));
			res.setTrain(res.getTrain() + (src.getTrain() == null ? 0d : src.getTrain()));
			res.setWalk(res.getWalk()   + (src.getWalk()  == null ? 0d : src.getWalk()));
			
		}
	}

}
