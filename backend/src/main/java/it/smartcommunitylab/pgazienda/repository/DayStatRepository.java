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

package it.smartcommunitylab.pgazienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import it.smartcommunitylab.pgazienda.domain.DayStat;

/**
 * @author raman
 *
 */
public interface DayStatRepository  extends MongoRepository<DayStat, String> {

	public List<DayStat> findByPlayerIdAndCampaign(String playerId, String campaign);

	@Query("{playerId:?0, campaign:?1, date : {$gte:?2 , $lt: ?3}}")
	public List<DayStat> findByPlayerIdAndCampaignAndPeriod(String playerId, String campaign, String from, String to);

	@Query("{playerId:?0, campaign:?1, date : ?2}")
	public DayStat findOneByPlayerIdAndCampaignAndDate(String key, String id, String date);
}