Feature: Navigate to Betting Website

  Scenario: Open Browser Navigate to William Hill Website
    Given Open Chrome and go to URL
    When Choose Home Team "Slovakia" and Away Team "Malta"
    And Choose Football Event and Place a Bet "0.05"
    Then Verify Stakes