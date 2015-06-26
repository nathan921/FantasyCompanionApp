package com.ddtpt.android.fantasycompanionapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by e228596 on 6/26/2015.
 */
public class JsonFactory {

    public class Bye_weeks {
        private String week;

        public String getWeek ()
        {
            return week;
        }

        public void setWeek (String week)
        {
            this.week = week;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [week = "+week+"]";
        }
    }

    public class Eligible_positions {
        private String position;

        public String getPosition ()
        {
            return position;
        }

        public void setPosition (String position)
        {
            this.position = position;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [position = "+position+"]";
        }
    }

    public class Headshot {
        private String url;

        private String size;

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public String getSize ()
        {
            return size;
        }

        public void setSize (String size)
        {
            this.size = size;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [url = "+url+", size = "+size+"]";
        }
    }

    public class League {

        private String league_type;

        private String end_week;

        private String renewed;

        private String current_week;

        private String game_code;

        private String short_invitation_url;

        private String renew;

        private String league_id;

        private String scoring_type;

        private String url;

        private String num_teams;

        private String league_chat_id;

        private String league_key;

        private String edit_key;

        private String end_date;

        private String is_pro_league;

        private String league_update_timestamp;

        private String season;

        private String draft_status;

        private String start_week;

        private String name;

        private String start_date;

        private String is_finished;

        public String getLeague_type ()
        {
            return league_type;
        }

        public void setLeague_type (String league_type)
        {
            this.league_type = league_type;
        }

        public String getEnd_week ()
        {
            return end_week;
        }

        public void setEnd_week (String end_week)
        {
            this.end_week = end_week;
        }

        public String getRenewed ()
        {
            return renewed;
        }

        public void setRenewed (String renewed)
        {
            this.renewed = renewed;
        }

        public String getCurrent_week ()
        {
            return current_week;
        }

        public void setCurrent_week (String current_week)
        {
            this.current_week = current_week;
        }

        public String getGame_code ()
        {
            return game_code;
        }

        public void setGame_code (String game_code)
        {
            this.game_code = game_code;
        }

        public String getShort_invitation_url ()
        {
            return short_invitation_url;
        }

        public void setShort_invitation_url (String short_invitation_url)
        {
            this.short_invitation_url = short_invitation_url;
        }

        public String getRenew ()
        {
            return renew;
        }

        public void setRenew (String renew)
        {
            this.renew = renew;
        }

        public String getLeague_id ()
        {
            return league_id;
        }

        public void setLeague_id (String league_id)
        {
            this.league_id = league_id;
        }

        public String getScoring_type ()
        {
            return scoring_type;
        }

        public void setScoring_type (String scoring_type)
        {
            this.scoring_type = scoring_type;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public String getNum_teams ()
        {
            return num_teams;
        }

        public void setNum_teams (String num_teams)
        {
            this.num_teams = num_teams;
        }

        public String getLeague_chat_id ()
        {
            return league_chat_id;
        }

        public void setLeague_chat_id (String league_chat_id)
        {
            this.league_chat_id = league_chat_id;
        }

        public String getLeague_key ()
        {
            return league_key;
        }

        public void setLeague_key (String league_key)
        {
            this.league_key = league_key;
        }

        public String getEdit_key ()
        {
            return edit_key;
        }

        public void setEdit_key (String edit_key)
        {
            this.edit_key = edit_key;
        }

        public String getEnd_date ()
        {
            return end_date;
        }

        public void setEnd_date (String end_date)
        {
            this.end_date = end_date;
        }

        public String getIs_pro_league ()
        {
            return is_pro_league;
        }

        public void setIs_pro_league (String is_pro_league)
        {
            this.is_pro_league = is_pro_league;
        }

        public String getLeague_update_timestamp ()
        {
            return league_update_timestamp;
        }

        public void setLeague_update_timestamp (String league_update_timestamp)
        {
            this.league_update_timestamp = league_update_timestamp;
        }

        public String getSeason ()
        {
            return season;
        }

        public void setSeason (String season)
        {
            this.season = season;
        }

        public String getDraft_status ()
        {
            return draft_status;
        }

        public void setDraft_status (String draft_status)
        {
            this.draft_status = draft_status;
        }

        public String getStart_week ()
        {
            return start_week;
        }

        public void setStart_week (String start_week)
        {
            this.start_week = start_week;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getStart_date ()
        {
            return start_date;
        }

        public void setStart_date (String start_date)
        {
            this.start_date = start_date;
        }

        public String getIs_finished ()
        {
            return is_finished;
        }

        public void setIs_finished (String is_finished)
        {
            this.is_finished = is_finished;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [league_type = "+league_type+", end_week = "+end_week+", renewed = "+renewed+", current_week = "+current_week+", game_code = "+game_code+", short_invitation_url = "+short_invitation_url+", renew = "+renew+", league_id = "+league_id+", scoring_type = "+scoring_type+", url = "+url+", num_teams = "+num_teams+", league_chat_id = "+league_chat_id+", league_key = "+league_key+", edit_key = "+edit_key+", end_date = "+end_date+", is_pro_league = "+is_pro_league+", league_update_timestamp = "+league_update_timestamp+", season = "+season+", draft_status = "+draft_status+", start_week = "+start_week+", name = "+name+", start_date = "+start_date+", is_finished = "+is_finished+"]";
        }

    }

    public class Manager {
        private String guid;

        private String image_url;

        private String email;

        private String nickname;

        private String manager_id;

        private String is_commissioner;

        private String is_current_login;

        public String getGuid ()
        {
            return guid;
        }

        public void setGuid (String guid)
        {
            this.guid = guid;
        }

        public String getImage_url ()
        {
            return image_url;
        }

        public void setImage_url (String image_url)
        {
            this.image_url = image_url;
        }

        public String getEmail ()
        {
            return email;
        }

        public void setEmail (String email)
        {
            this.email = email;
        }

        public String getNickname ()
        {
            return nickname;
        }

        public void setNickname (String nickname)
        {
            this.nickname = nickname;
        }

        public String getManager_id ()
        {
            return manager_id;
        }

        public void setManager_id (String manager_id)
        {
            this.manager_id = manager_id;
        }

        public String getIs_commissioner ()
        {
            return is_commissioner;
        }

        public void setIs_commissioner (String is_commissioner)
        {
            this.is_commissioner = is_commissioner;
        }

        public String getIs_current_login ()
        {
            return is_current_login;
        }

        public void setIs_current_login (String is_current_login)
        {
            this.is_current_login = is_current_login;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [guid = "+guid+", image_url = "+image_url+", email = "+email+", nickname = "+nickname+", manager_id = "+manager_id+", is_commissioner = "+is_commissioner+", is_current_login = "+is_current_login+"]";
        }
    }

    public class Managers {
        private Manager manager;

        public Manager getManager ()
        {
            return manager;
        }

        public void setManager (Manager manager)
        {
            this.manager = manager;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [manager = "+manager+"]";
        }
    }

    public class Matchup {

        private String week;
        private String week_start;
        private String week_end;
        private String status;
        private String is_playoffs;
        private String is_consolation;
        private String is_tied;
        private String winner_team_key;
        private Teams teams;

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWeek_start() {
            return week_start;
        }

        public void setWeek_start(String week_start) {
            this.week_start = week_start;
        }

        public String getWeek_end() {
            return week_end;
        }

        public void setWeek_end(String week_end) {
            this.week_end = week_end;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_playoffs() {
            return is_playoffs;
        }

        public void setIs_playoffs(String is_playoffs) {
            this.is_playoffs = is_playoffs;
        }

        public String getIs_consolation() {
            return is_consolation;
        }

        public void setIs_consolation(String is_consolation) {
            this.is_consolation = is_consolation;
        }

        public String getIs_tied() {
            return is_tied;
        }

        public void setIs_tied(String is_tied) {
            this.is_tied = is_tied;
        }

        public String getWinner_team_key() {
            return winner_team_key;
        }

        public void setWinner_team_key(String winner_team_key) {
            this.winner_team_key = winner_team_key;
        }

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }
    }

    public class Matchups {

        private String count;
        private List<Matchup> matchup = new ArrayList<Matchup>();

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<Matchup> getMatchup() {
            return matchup;
        }

        public void setMatchup(List<Matchup> matchup) {
            this.matchup = matchup;
        }
    }

    public class Name {
        private String ascii_first;

        private String last;

        private String ascii_last;

        private String full;

        private String first;

        public String getAscii_first ()
        {
            return ascii_first;
        }

        public void setAscii_first (String ascii_first)
        {
            this.ascii_first = ascii_first;
        }

        public String getLast ()
        {
            return last;
        }

        public void setLast (String last)
        {
            this.last = last;
        }

        public String getAscii_last ()
        {
            return ascii_last;
        }

        public void setAscii_last (String ascii_last)
        {
            this.ascii_last = ascii_last;
        }

        public String getFull ()
        {
            return full;
        }

        public void setFull (String full)
        {
            this.full = full;
        }

        public String getFirst ()
        {
            return first;
        }

        public void setFirst (String first)
        {
            this.first = first;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [ascii_first = "+ascii_first+", last = "+last+", ascii_last = "+ascii_last+", full = "+full+", first = "+first+"]";
        }
    }

    public class Outcome_totals {

        private String wins;
        private String losses;
        private String ties;
        private String percentage;

        public String getWins() {
            return wins;
        }

        public void setWins(String wins) {
            this.wins = wins;
        }

        public String getLosses() {
            return losses;
        }

        public void setLosses(String losses) {
            this.losses = losses;
        }

        public String getTies() {
            return ties;
        }

        public void setTies(String ties) {
            this.ties = ties;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }
    }

    public class Ownership {

        private String ownership_type;
        private String owner_team_key;
        private String owner_team_name;
        private Teams teams;

        public String getOwnership_type() {
            return ownership_type;
        }

        public void setOwnership_type(String ownership_type) {
            this.ownership_type = ownership_type;
        }

        public String getOwner_team_key() {
            return owner_team_key;
        }

        public void setOwner_team_key(String owner_team_key) {
            this.owner_team_key = owner_team_key;
        }

        public String getOwner_team_name() {
            return owner_team_name;
        }

        public void setOwner_team_name(String owner_team_name) {
            this.owner_team_name = owner_team_name;
        }

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }
    }

    public class Player {
        private String editorial_team_full_name;

        private String display_position;

        private Headshot headshot;

        private String player_key;

        private String editorial_team_abbr;

        private Eligible_positions eligible_positions;

        private String uniform_number;

        private String position_type;

        private Bye_weeks bye_weeks;

        private String image_url;

        private Name name;

        private String is_editable;

        private Selected_position selected_position;

        private String is_undroppable;

        private String player_id;

        private String editorial_team_key;

        private String editorial_player_key;

        public String getEditorial_team_full_name ()
        {
            return editorial_team_full_name;
        }

        public void setEditorial_team_full_name (String editorial_team_full_name)
        {
            this.editorial_team_full_name = editorial_team_full_name;
        }

        public String getDisplay_position ()
        {
            return display_position;
        }

        public void setDisplay_position (String display_position)
        {
            this.display_position = display_position;
        }

        public Headshot getHeadshot ()
        {
            return headshot;
        }

        public void setHeadshot (Headshot headshot)
        {
            this.headshot = headshot;
        }

        public String getPlayer_key ()
        {
            return player_key;
        }

        public void setPlayer_key (String player_key)
        {
            this.player_key = player_key;
        }

        public String getEditorial_team_abbr ()
        {
            return editorial_team_abbr;
        }

        public void setEditorial_team_abbr (String editorial_team_abbr)
        {
            this.editorial_team_abbr = editorial_team_abbr;
        }

        public Eligible_positions getEligible_positions ()
        {
            return eligible_positions;
        }

        public void setEligible_positions (Eligible_positions eligible_positions)
        {
            this.eligible_positions = eligible_positions;
        }

        public String getUniform_number ()
        {
            return uniform_number;
        }

        public void setUniform_number (String uniform_number)
        {
            this.uniform_number = uniform_number;
        }

        public String getPosition_type ()
        {
            return position_type;
        }

        public void setPosition_type (String position_type)
        {
            this.position_type = position_type;
        }

        public Bye_weeks getBye_weeks ()
        {
            return bye_weeks;
        }

        public void setBye_weeks (Bye_weeks bye_weeks)
        {
            this.bye_weeks = bye_weeks;
        }

        public String getImage_url ()
        {
            return image_url;
        }

        public void setImage_url (String image_url)
        {
            this.image_url = image_url;
        }

        public Name getName ()
        {
            return name;
        }

        public void setName (Name name)
        {
            this.name = name;
        }

        public String getIs_editable ()
        {
            return is_editable;
        }

        public void setIs_editable (String is_editable)
        {
            this.is_editable = is_editable;
        }

        public Selected_position getSelected_position ()
        {
            return selected_position;
        }

        public void setSelected_position (Selected_position selected_position)
        {
            this.selected_position = selected_position;
        }

        public String getIs_undroppable ()
        {
            return is_undroppable;
        }

        public void setIs_undroppable (String is_undroppable)
        {
            this.is_undroppable = is_undroppable;
        }

        public String getPlayer_id ()
        {
            return player_id;
        }

        public void setPlayer_id (String player_id)
        {
            this.player_id = player_id;
        }

        public String getEditorial_team_key ()
        {
            return editorial_team_key;
        }

        public void setEditorial_team_key (String editorial_team_key)
        {
            this.editorial_team_key = editorial_team_key;
        }

        public String getEditorial_player_key ()
        {
            return editorial_player_key;
        }

        public void setEditorial_player_key (String editorial_player_key)
        {
            this.editorial_player_key = editorial_player_key;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [editorial_team_full_name = "+editorial_team_full_name+", display_position = "+display_position+", headshot = "+headshot+", player_key = "+player_key+", editorial_team_abbr = "+editorial_team_abbr+", eligible_positions = "+eligible_positions+", uniform_number = "+uniform_number+", position_type = "+position_type+", bye_weeks = "+bye_weeks+", image_url = "+image_url+", name = "+name+", is_editable = "+is_editable+", selected_position = "+selected_position+", is_undroppable = "+is_undroppable+", player_id = "+player_id+", editorial_team_key = "+editorial_team_key+", editorial_player_key = "+editorial_player_key+"]";
        }
    }

    public class Players {
        private Player[] player;

        private String count;

        public Player[] getPlayer ()
        {
            return player;
        }

        public void setPlayer (Player[] player)
        {
            this.player = player;
        }

        public String getCount ()
        {
            return count;
        }

        public void setCount (String count)
        {
            this.count = count;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [player = "+player+", count = "+count+"]";
        }
    }

    public class Player_points {

        private String coverage_type;
        private String week;
        private String total;

        public String getCoverage_type() {
            return coverage_type;
        }

        public void setCoverage_type(String coverage_type) {
            this.coverage_type = coverage_type;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    public class Player_stats {

        private String coverage_type;
        private String week;
        private Stats stats;

        public String getCoverage_type() {
            return coverage_type;
        }

        public void setCoverage_type(String coverage_type) {
            this.coverage_type = coverage_type;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }
    }

    public class Roster  {
        private Players players;

        private String is_editable;

        private String week;

        private String coverage_type;

        public Players getPlayers ()
        {
            return players;
        }

        public void setPlayers (Players players)
        {
            this.players = players;
        }

        public String getIs_editable ()
        {
            return is_editable;
        }

        public void setIs_editable (String is_editable)
        {
            this.is_editable = is_editable;
        }

        public String getWeek ()
        {
            return week;
        }

        public void setWeek (String week)
        {
            this.week = week;
        }

        public String getCoverage_type ()
        {
            return coverage_type;
        }

        public void setCoverage_type (String coverage_type)
        {
            this.coverage_type = coverage_type;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [players = "+players+", is_editable = "+is_editable+", week = "+week+", coverage_type = "+coverage_type+"]";
        }
    }

    public class Roster_adds {
        private String value;

        private String coverage_value;

        private String coverage_type;

        public String getValue ()
        {
            return value;
        }

        public void setValue (String value)
        {
            this.value = value;
        }

        public String getCoverage_value ()
        {
            return coverage_value;
        }

        public void setCoverage_value (String coverage_value)
        {
            this.coverage_value = coverage_value;
        }

        public String getCoverage_type ()
        {
            return coverage_type;
        }

        public void setCoverage_type (String coverage_type)
        {
            this.coverage_type = coverage_type;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [value = "+value+", coverage_value = "+coverage_value+", coverage_type = "+coverage_type+"]";
        }
    }

    public class Roster_position {

        private String position;
        private String position_type;
        private String count;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPosition_type() {
            return position_type;
        }

        public void setPosition_type(String position_type) {
            this.position_type = position_type;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public class Roster_positions {

        private List<Roster_position> roster_position = new ArrayList<Roster_position>();

        public List<Roster_position> getRoster_position() {
            return roster_position;
        }

        public void setRoster_position(List<Roster_position> roster_position) {
            this.roster_position = roster_position;
        }
    }

    public class Scoreboard {

        private String week;
        private Matchups matchups;

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public Matchups getMatchups() {
            return matchups;
        }

        public void setMatchups(Matchups matchups) {
            this.matchups = matchups;
        }
    }

    public class Selected_position {
        private String position;

        private String week;

        private String coverage_type;

        public String getPosition ()
        {
            return position;
        }

        public void setPosition (String position)
        {
            this.position = position;
        }

        public String getWeek ()
        {
            return week;
        }

        public void setWeek (String week)
        {
            this.week = week;
        }

        public String getCoverage_type ()
        {
            return coverage_type;
        }

        public void setCoverage_type (String coverage_type)
        {
            this.coverage_type = coverage_type;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [position = "+position+", week = "+week+", coverage_type = "+coverage_type+"]";
        }
    }

    public class Settings {

        private String draft_type;
        private String is_auction_draft;
        private String scoring_type;
        private String uses_playoff;
        private String has_playoff_consolation_games;
        private String playoff_start_week;
        private String uses_playoff_reseeding;
        private String uses_lock_eliminated_teams;
        private String num_playoff_teams;
        private String num_playoff_consolation_teams;
        private String waiver_type;
        private String waiver_rule;
        private String uses_faab;
        private String draft_time;
        private String draft_pick_time;
        private String post_draft_players;
        private String max_teams;
        private String waiver_time;
        private String trade_end_date;
        private String trade_ratify_type;
        private String trade_reject_time;
        private String player_pool;
        private String cant_cut_list;
        private Roster_positions roster_positions;
        private Stat_categories stat_categories;
        //TODO: Figure out what this does
        //private Stat_modifiers stat_modifiers;
        private String pickem_enabled;
        private String uses_fractional_points;
        private String uses_negative_points;

        public String getDraft_type() {
            return draft_type;
        }

        public void setDraft_type(String draft_type) {
            this.draft_type = draft_type;
        }

        public String getIs_auction_draft() {
            return is_auction_draft;
        }

        public void setIs_auction_draft(String is_auction_draft) {
            this.is_auction_draft = is_auction_draft;
        }

        public String getScoring_type() {
            return scoring_type;
        }

        public void setScoring_type(String scoring_type) {
            this.scoring_type = scoring_type;
        }

        public String getUses_playoff() {
            return uses_playoff;
        }

        public void setUses_playoff(String uses_playoff) {
            this.uses_playoff = uses_playoff;
        }

        public String getHas_playoff_consolation_games() {
            return has_playoff_consolation_games;
        }

        public void setHas_playoff_consolation_games(String has_playoff_consolation_games) {
            this.has_playoff_consolation_games = has_playoff_consolation_games;
        }

        public String getPlayoff_start_week() {
            return playoff_start_week;
        }

        public void setPlayoff_start_week(String playoff_start_week) {
            this.playoff_start_week = playoff_start_week;
        }

        public String getUses_playoff_reseeding() {
            return uses_playoff_reseeding;
        }

        public void setUses_playoff_reseeding(String uses_playoff_reseeding) {
            this.uses_playoff_reseeding = uses_playoff_reseeding;
        }

        public String getUses_lock_eliminated_teams() {
            return uses_lock_eliminated_teams;
        }

        public void setUses_lock_eliminated_teams(String uses_lock_eliminated_teams) {
            this.uses_lock_eliminated_teams = uses_lock_eliminated_teams;
        }

        public String getNum_playoff_teams() {
            return num_playoff_teams;
        }

        public void setNum_playoff_teams(String num_playoff_teams) {
            this.num_playoff_teams = num_playoff_teams;
        }

        public String getNum_playoff_consolation_teams() {
            return num_playoff_consolation_teams;
        }

        public void setNum_playoff_consolation_teams(String num_playoff_consolation_teams) {
            this.num_playoff_consolation_teams = num_playoff_consolation_teams;
        }

        public String getWaiver_type() {
            return waiver_type;
        }

        public void setWaiver_type(String waiver_type) {
            this.waiver_type = waiver_type;
        }

        public String getWaiver_rule() {
            return waiver_rule;
        }

        public void setWaiver_rule(String waiver_rule) {
            this.waiver_rule = waiver_rule;
        }

        public String getUses_faab() {
            return uses_faab;
        }

        public void setUses_faab(String uses_faab) {
            this.uses_faab = uses_faab;
        }

        public String getDraft_time() {
            return draft_time;
        }

        public void setDraft_time(String draft_time) {
            this.draft_time = draft_time;
        }

        public String getDraft_pick_time() {
            return draft_pick_time;
        }

        public void setDraft_pick_time(String draft_pick_time) {
            this.draft_pick_time = draft_pick_time;
        }

        public String getPost_draft_players() {
            return post_draft_players;
        }

        public void setPost_draft_players(String post_draft_players) {
            this.post_draft_players = post_draft_players;
        }

        public String getMax_teams() {
            return max_teams;
        }

        public void setMax_teams(String max_teams) {
            this.max_teams = max_teams;
        }

        public String getWaiver_time() {
            return waiver_time;
        }

        public void setWaiver_time(String waiver_time) {
            this.waiver_time = waiver_time;
        }

        public String getTrade_end_date() {
            return trade_end_date;
        }

        public void setTrade_end_date(String trade_end_date) {
            this.trade_end_date = trade_end_date;
        }

        public String getTrade_ratify_type() {
            return trade_ratify_type;
        }

        public void setTrade_ratify_type(String trade_ratify_type) {
            this.trade_ratify_type = trade_ratify_type;
        }

        public String getTrade_reject_time() {
            return trade_reject_time;
        }

        public void setTrade_reject_time(String trade_reject_time) {
            this.trade_reject_time = trade_reject_time;
        }
    }

    public class Standings {

        private Teams teams;

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }
    }

    public class Stat {

        private String stat_id;
        private String value;

        public String getStat_id() {
            return stat_id;
        }

        public void setStat_id(String stat_id) {
            this.stat_id = stat_id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public class Stats {

        private List<Stat> stat = new ArrayList<Stat>();

        public List<Stat> getStat() {
            return stat;
        }

        public void setStat(List<Stat> stat) {
            this.stat = stat;
        }
    }

    public class Stat_categories {

        private Stats stats;

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }
    }

    public class Stat_type {

        private String stat_id;
        private String enabled;
        private String name;
        private String display_name;
        private String sort_order;
        private String position_type;
        private Stat_position_types stat_position_types;
        private String is_only_display_stat;
        private String is_excluded_from_display;

        public String getStat_id() {
            return stat_id;
        }

        public void setStat_id(String stat_id) {
            this.stat_id = stat_id;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getPosition_type() {
            return position_type;
        }

        public void setPosition_type(String position_type) {
            this.position_type = position_type;
        }

        public Stat_position_types getStat_position_types() {
            return stat_position_types;
        }

        public void setStat_position_types(Stat_position_types stat_position_types) {
            this.stat_position_types = stat_position_types;
        }

        public String getIs_only_display_stat() {
            return is_only_display_stat;
        }

        public void setIs_only_display_stat(String is_only_display_stat) {
            this.is_only_display_stat = is_only_display_stat;
        }

        public String getIs_excluded_from_display() {
            return is_excluded_from_display;
        }

        public void setIs_excluded_from_display(String is_excluded_from_display) {
            this.is_excluded_from_display = is_excluded_from_display;
        }
    }

    public class Stat_types {
        private List<Stat_type> stat_type = new ArrayList<Stat_type>();

        public List<Stat_type> getStatType() {
            return stat_type;
        }

        public void setStatType(List<Stat_type> stat_type) {
            this.stat_type = stat_type;
        }
    }

    public class Stat_position_type {

        private String position_type;

        public String getPosition_type() {
            return position_type;
        }

        public void setPosition_type(String position_type) {
            this.position_type = position_type;
        }
    }

    public class Stat_position_types {

        private Stat_position_type stat_position_type;

        public Stat_position_type getStat_position_type() {
            return stat_position_type;
        }

        public void setStat_position_type(Stat_position_type stat_position_type) {
            this.stat_position_type = stat_position_type;
        }
    }

    public class Streak {

        private String type;
        private String value;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Map<String, Object> getAdditionalProperties() {
            return additionalProperties;
        }

        public void setAdditionalProperties(Map<String, Object> additionalProperties) {
            this.additionalProperties = additionalProperties;
        }
    }

    public class Team {
        private String clinched_playoffs;

        private String number_of_moves;

        private Managers managers;

        private String league_scoring_type;

        private String is_owned_by_current_login;

        private String team_key;

        private String name;

        private String number_of_trades;

        private Team_logos team_logos;

        private Roster_adds roster_adds;

        private String team_id;

        private String url;

        private String waiver_priority;

        public String getClinched_playoffs ()
        {
            return clinched_playoffs;
        }

        public void setClinched_playoffs (String clinched_playoffs)
        {
            this.clinched_playoffs = clinched_playoffs;
        }

        public String getNumber_of_moves ()
        {
            return number_of_moves;
        }

        public void setNumber_of_moves (String number_of_moves)
        {
            this.number_of_moves = number_of_moves;
        }

        public Managers getManagers ()
        {
            return managers;
        }

        public void setManagers (Managers managers)
        {
            this.managers = managers;
        }

        public String getLeague_scoring_type ()
        {
            return league_scoring_type;
        }

        public void setLeague_scoring_type (String league_scoring_type)
        {
            this.league_scoring_type = league_scoring_type;
        }

        public String getIs_owned_by_current_login ()
        {
            return is_owned_by_current_login;
        }

        public void setIs_owned_by_current_login (String is_owned_by_current_login)
        {
            this.is_owned_by_current_login = is_owned_by_current_login;
        }

        public String getTeam_key ()
        {
            return team_key;
        }

        public void setTeam_key (String team_key)
        {
            this.team_key = team_key;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getNumber_of_trades ()
        {
            return number_of_trades;
        }

        public void setNumber_of_trades (String number_of_trades)
        {
            this.number_of_trades = number_of_trades;
        }

        public Team_logos getTeam_logos ()
        {
            return team_logos;
        }

        public void setTeam_logos (Team_logos team_logos)
        {
            this.team_logos = team_logos;
        }

        public Roster_adds getRoster_adds ()
        {
            return roster_adds;
        }

        public void setRoster_adds (Roster_adds roster_adds)
        {
            this.roster_adds = roster_adds;
        }

        public String getTeam_id ()
        {
            return team_id;
        }

        public void setTeam_id (String team_id)
        {
            this.team_id = team_id;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public String getWaiver_priority ()
        {
            return waiver_priority;
        }

        public void setWaiver_priority (String waiver_priority)
        {
            this.waiver_priority = waiver_priority;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [clinched_playoffs = "+clinched_playoffs+", number_of_moves = "+number_of_moves+", managers = "+managers+", league_scoring_type = "+league_scoring_type+", is_owned_by_current_login = "+is_owned_by_current_login+", team_key = "+team_key+", name = "+name+", number_of_trades = "+number_of_trades+", team_logos = "+team_logos+", roster_adds = "+roster_adds+", team_id = "+team_id+", url = "+url+", waiver_priority = "+waiver_priority+"]";
        }
    }

    public class Teams {

        private String count;
        private List<Team> team = new ArrayList<Team>();

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<Team> getTeam() {
            return team;
        }

        public void setTeam(List<Team> team) {
            this.team = team;
        }
    }

    public class Team_logo {
        private String url;

        private String size;

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public String getSize ()
        {
            return size;
        }

        public void setSize (String size)
        {
            this.size = size;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [url = "+url+", size = "+size+"]";
        }
    }

    public class Team_logos {
        private Team_logo team_logo;

        public Team_logo getTeam_logo ()
        {
            return team_logo;
        }

        public void setTeam_logo (Team_logo team_logo)
        {
            this.team_logo = team_logo;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [team_logo = "+team_logo+"]";
        }
    }

    public class Team_points {

        private String coverage_type;
        private String season;
        private String total;

        public String getCoverage_type() {
            return coverage_type;
        }

        public void setCoverage_type(String coverage_type) {
            this.coverage_type = coverage_type;
        }

        public String getSeason() {
            return season;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    public class Team_projected_points {

        private String coverage_type;
        private String week;
        private String total;

        public String getCoverage_type() {
            return coverage_type;
        }

        public void setCoverage_type(String coverage_type) {
            this.coverage_type = coverage_type;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    public class Team_standings {

        private String rank;
        private Outcome_totals outcome_totals;
        private Streak streak;
        private String points_for;
        private String points_against;

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public Outcome_totals getOutcome_totals() {
            return outcome_totals;
        }

        public void setOutcome_totals(Outcome_totals outcome_totals) {
            this.outcome_totals = outcome_totals;
        }

        public Streak getStreak() {
            return streak;
        }

        public void setStreak(Streak streak) {
            this.streak = streak;
        }

        public String getPoints_for() {
            return points_for;
        }

        public void setPoints_for(String points_for) {
            this.points_for = points_for;
        }

        public String getPoints_against() {
            return points_against;
        }

        public void setPoints_against(String points_against) {
            this.points_against = points_against;
        }
    }
}
