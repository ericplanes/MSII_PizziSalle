package com.salle.persistence;

import com.salle.utilities.exceptions.NotFoundException;

import java.security.InvalidParameterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.salle.application.dto.ClientDTO;

public class ClientRepository {

    public void saveClient(ClientDTO client) throws Exception {
        ConnectionBBDD connection = ConnectionRepository.getConnection();

        String sql = "Insert into CLIENT(NAME, SURNAME, PHONE, ADDRESS, DELEGATION, BIRTHDATE, REGDATE, COMDONE) values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, client.getName());
        pst.setString(2, client.getSurname());
        pst.setString(3, client.getPhone());
        pst.setString(4, client.getAddress());
        pst.setString(5, client.getDelegation());
        pst.setDate(6, Date.valueOf(client.getBirthDate()));
        pst.setDate(7, Date.valueOf(client.getRegistrationDate()));
        pst.setInt(8, client.getCommandsDone());


        if (pst.executeUpdate() != 1) {
            throw new InvalidParameterException("savePlayer went wrong because PreparedStatement.executeUpdate() == 1");
        }
		
		/* Codi utilitzat anteriorment per lligar taules de la base de dades
		insertPlayerDeck(client);
		updatePlayerSpellList(client);
		*/
    }

    public void updateClient(ClientDTO client) throws Exception {
        ConnectionBBDD connection = ConnectionRepository.getConnection();
        try {
            String sql = "UPDATE CLIENT SET ADDRESS=?, DELEGATION=?, COMDONE=? WHERE PHONE=?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.clearParameters();
            pst.setString(1, client.getAddress());
            pst.setString(2, client.getDelegation());
            pst.setInt(3, client.getCommandsDone());
            pst.setString(4, client.getPhone());

            if (pst.executeUpdate() != 1) {
                throw new InvalidParameterException("updatePlayer went wrong, the player couldn't get updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("SQLException class error ocurred, the message is: \n" + e.getMessage());
        }
		/* Codi utilitzat anteriorment per lligar taules de la base de dades
		updatePlayerDeck(client);
		updatePlayerSpellList(client);
		*/
    }

    public ClientDTO getClient(String phone) throws Exception {
        ConnectionBBDD connection = ConnectionRepository.getConnection();

        try {
            String sql = "SELECT * FROM CLIENT WHERE PHONE=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.clearParameters();

            preparedStatement.setString(1, phone);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return createClientDTOFromBBDD(rs);
            }

            throw new NotFoundException("Client not found on the data base.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("SQLException class error ocurred, the message is: \n" + e.getMessage());
        }
    }

	/*
	public void deleteClient(ClientDTO client) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			PreparedStatement st;
			st = connection.prepareStatement("DELETE FROM PLAYER WHERE PHONE = ?");
			st.setString(1, client.getPhone());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("SQLException class error ocurred, the message is: \n" + e.getMessage());
		}
	}
	*/

	/*
	public List<Player> getAllPlayers() throws Exception {
		List<Player> result = new ArrayList<>();
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		String sql = "SELECT * FROM PLAYER";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Player p = this.createPlayerFromBBDD(rs);
			result.add(p);
		}

		return result;
	}
	*/

	/*
	private void addSpellToPlayer(Player player, Spell spell) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		String sql = "Insert into PLAYERSPELLS(PLAYERNAME, SPELLNAME) values (?, ?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, player.getUserName());
		pst.setString(2, spell.getSpellName());

		if (pst.executeUpdate() != 1) {
			throw new InvalidParameterException("saveSpellToPlayer went wrong because PreparedStatement.executeUpdate() == 1");
		}
	}
	*/

	/*
	private void updatePlayerDeck(Player player) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "UPDATE PLAYERDECK SET ATACKSPELLNAME=?, UTILITYSPELLNAME=?, ULTISPELLNAME=? WHERE PLAYERNAME=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.clearParameters();
			pst.setString(1, player.getDeck()[0].getSpellName());
			pst.setString(2, player.getDeck()[1].getSpellName());
			pst.setString(3, player.getDeck()[2].getSpellName());
			pst.setString(4, player.getUserName());
			
			if(pst.executeUpdate()!=1) {
				throw new InvalidParameterException("updatePlayer went wrong because PreparedStatement.executeUpdate() == 1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	*/

	/*
	private void insertPlayerDeck(Player player) throws Exception {
		try {

			ConnectionBBDD connection = ConnectionRepository.getConnection();

			String sql = "Insert into PLAYERDECK(PLAYERNAME, ATACKSPELLNAME, UTILITYSPELLNAME, ULTISPELLNAME) values (?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, player.getUserName());
			pst.setString(2, player.getDeck()[0].getSpellName());
			pst.setString(3, player.getDeck()[1].getSpellName());
			pst.setString(4, player.getDeck()[2].getSpellName());

			if (pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}
	*/

	/*
	private void updatePlayerSpellList(Player player) throws Exception{
		List<String> spellsBDD = getAllSpellsFromPlayer(player.getUserName());
		List<String> spellsPlayer = player.getStringSpellList();
		
		for(String spell : spellsPlayer) {
			if(!(spellsBDD.contains(spell))) addSpellToPlayer(player, SpellController.getInstance().getSpellByName(spell));
		}
	}
	*/

	/*
	private List<Spell> convertAllSpellsFromPlayer(String playerName) throws Exception {
		List<Spell> spellList = new ArrayList<Spell>();
	
		for(String spellName : getAllSpellsFromPlayer(playerName)) {
			spellList.add(SpellController.getInstance().getSpellByName(spellName));
		}
		
		return spellList;
	}
	*/

	/*
	private List<String> getAllSpellsFromPlayer(String playerName) throws Exception {

		List<String> result = new ArrayList<>();
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		try {
			String sql = "SELECT * FROM PLAYERSPELLS WHERE PLAYERNAME=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.clearParameters();

			preparedStatement.setString(1, playerName);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("SPELLNAME");
				result.add(id);
			}

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}
	*/

	/*
	private Spell[] convertDeckFromPlayer(String playerName) throws Exception {
		Spell[] playerDeck = new Spell[3];
		int counter=0;
		
		for(String spellName : getDeckFromPlayer(playerName)) {
			playerDeck[counter] = SpellController.getInstance().getSpellByName(spellName);
			counter++;
		}
		
		return playerDeck;
	}
	*/

	/*
	private List<String> getDeckFromPlayer(String playerName) throws Exception {

		List<String> result = new ArrayList<>();
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		try {
			String sql = "SELECT * FROM PLAYERDECK WHERE PLAYERNAME=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.clearParameters();

			preparedStatement.setString(1, playerName);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String atackSpell = rs.getString("ATACKSPELLNAME");
				String utilitySpell = rs.getString("UTILITYSPELLNAME");
				String ultimateSpell = rs.getString("ULTISPELLNAME");
				
				result.add(atackSpell);
				result.add(utilitySpell);
				result.add(ultimateSpell);
			}

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}
	*/

    private ClientDTO createClientDTOFromBBDD(ResultSet rs) throws Exception {
        String name = rs.getString("NAME");
        String surname = rs.getString("SURNAME");
        String phone = rs.getString("PHONE");
        String address = rs.getString("ADDRESS");
        String delegation = rs.getString("DELEGATION");
        Date birthDate = rs.getDate("BIRTHDATE");
        Date registrationDate = rs.getDate("REGDATE");
        int comdone = rs.getInt("COMDONE");

        return new ClientDTO(name, surname, phone, address, delegation, birthDate.toLocalDate(), registrationDate.toLocalDate(), comdone);
    }
}
