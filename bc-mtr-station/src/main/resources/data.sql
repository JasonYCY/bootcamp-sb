INSERT INTO mtr_lines (line_code, description) VALUES
('AEL', 'Airport Express'),
('TCL', 'Tung Chung Line'),
('TML', 'Tuen Ma Line'),
('TKL', 'Tseung Kwan O Line'),
('EAL', 'East Rail Line'),
('SIL', 'South Island Line'),
('TWL', 'Tsuen Wan Line'),
('ISL', 'Island Line'),
('KTL', 'Kwun Tong Line'),
('DRL', 'Disneyland Resort Line');

INSERT INTO mtr_stations (station_code, description) VALUES
-- AEL Stations (5)
('HOK', 'Hong Kong'),
('KOW', 'Kowloon'),
('TSY', 'Tsing Yi'),
('AIR', 'Airport'),
('AWE', 'AsiaWorld Expo'),

-- TCL Stations (8) - Including HOK, KOW, TSY already inserted
('OLY', 'Olympic'),
('NAC', 'Nam Cheong'),
('LAK', 'Lai King'),
('SUN', 'Sunny Bay'),
('TUC', 'Tung Chung'),

-- TML Stations (27) - Including NAC already inserted
('WKS', 'Wu Kai Sha'),
('MOS', 'Ma On Shan'),
('HEO', 'Heng On'),
('TSH', 'Tai Shui Hang'),
('SHM', 'Shek Mun'),
('CIO', 'City One'),
('STW', 'Sha Tin Wai'),
('CKT', 'Che Kung Temple'),
('TAW', 'Tai Wai'),
('HIK', 'Hin Keng'),
('DIH', 'Diamond Hill'),
('KAT', 'Kai Tak'),
('SUW', 'Sung Wong Toi'),
('TKW', 'To Kwa Wan'),
('HOM', 'Ho Man Tin'),
('HUH', 'Hung Hom'),
('ETS', 'East Tsim Sha Tsui'),
('AUS', 'Austin'),
('MEF', 'Mei Foo'),
('TWW', 'Tsuen Wan West'),
('KSR', 'Kam Sheung Road'),
('YUL', 'Yuen Long'),
('LOP', 'Long Ping'),
('TIS', 'Tin Shui Wai'),
('SIH', 'Siu Hong'),
('TUM', 'Tuen Mun'),

-- TKL Stations (8)
('NOP', 'North Point'),
('QUB', 'Quarry Bay'),
('YAT', 'Yau Tong'),
('TIK', 'Tiu Keng Leng'),
('TKO', 'Tseung Kwan O'),
('LHP', 'LOHAS Park'),
('HAH', 'Hang Hau'),
('POA', 'Po Lam'),

-- EAL Stations (16) - Including HUH, TAW, DIH already inserted
('ADM', 'Admiralty'),
('EXC', 'Exhibition Centre'),
('MKK', 'Mong Kok East'),
('KOT', 'Kowloon Tong'),
('SHT', 'Sha Tin'),
('FOT', 'Fo Tan'),
('RAC', 'Racecourse'),
('UNI', 'University'),
('TAP', 'Tai Po Market'),
('TWO', 'Tai Wo'),
('FAN', 'Fanling'),
('SHS', 'Sheung Shui'),
('LOW', 'Lo Wu'),
('LMC', 'Lok Ma Chau'),

-- SIL Stations (5) - Including ADM already inserted
('OCP', 'Ocean Park'),
('WCH', 'Wong Chuk Hang'),
('LET', 'Lei Tung'),
('SOH', 'South Horizons'),

-- TWL Stations (16) - Including ADM, YMT, MOK, PRE, MEF, LAK already inserted
('CEN', 'Central'),
('TST', 'Tsim Sha Tsui'),
('JOR', 'Jordan'),
('YMT', 'Yau Ma Tei'),
('MOK', 'Mong Kok'),
('PRE', 'Prince Edward'),
('SSP', 'Sham Shui Po'),
('CSW', 'Cheung Sha Wan'),
('LCK', 'Lai Chi Kok'),
('KWF', 'Kwai Fong'),
('KWH', 'Kwai Hing'),
('TWH', 'Tai Wo Hau'),
('TSW', 'Tsuen Wan'),

-- ISL Stations (17) - Including CEN, ADM, NOP, QUB already inserted
('KET', 'Kennedy Town'),
('HKU', 'HKU'),
('SYP', 'Sai Ying Pun'),
('SHW', 'Sheung Wan'),
('WAC', 'Wan Chai'),
('CAB', 'Causeway Bay'),
('TIH', 'Tin Hau'),
('FOH', 'Fortress Hill'),
('TAK', 'Tai Koo'),
('SWH', 'Sai Wan Ho'),
('SKW', 'Shau Kei Wan'),
('HFC', 'Heng Fa Chuen'),
('CHW', 'Chai Wan'),

-- KTL Stations (17) - Including HOM, YMT, MOK, PRE, KOT, DIH, YAT, TIK already inserted
('WHA', 'Whampoa'),
('SKM', 'Shek Kip Mei'),
('LOF', 'Lok Fu'),
('WTS', 'Wong Tai Sin'),
('CHH', 'Choi Hung'),
('KOB', 'Kowloon Bay'),
('NTK', 'Ngau Tau Kok'),
('KWT', 'Kwun Tong'),
('LAT', 'Lam Tin'),

-- DRL Stations (2) - Including SUN already inserted
('DIS', 'Disneyland Resort');

-- 插入所有线路-车站关系 (使用sequence_order方案)
-- AEL: HOK(1) -> KOW(2) -> TSY(3) -> AIR(4) -> AWE(5)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(1, 1, 1),  -- HOK
(1, 2, 2),  -- KOW
(1, 3, 3),  -- TSY
(1, 4, 4),  -- AIR
(1, 5, 5);  -- AWE

-- TCL: HOK(1) -> KOW(2) -> OLY(6) -> NAC(7) -> LAK(8) -> TSY(3) -> SUN(9) -> TUC(10)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(2, 1, 1),  -- HOK
(2, 2, 2),  -- KOW
(2, 6, 3),  -- OLY
(2, 7, 4),  -- NAC
(2, 8, 5),  -- LAK
(2, 3, 6),  -- TSY
(2, 9, 7),  -- SUN
(2, 10, 8); -- TUC

-- TML: WKS(11) -> MOS(12) -> HEO(13) -> TSH(14) -> SHM(15) -> CIO(16) -> STW(17) -> CKT(18) -> TAW(19) -> HIK(20) -> DIH(21) -> KAT(22) -> SUW(23) -> TKW(24) -> HOM(25) -> HUH(26) -> ETS(27) -> AUS(28) -> NAC(7) -> MEF(29) -> TWW(30) -> KSR(31) -> YUL(32) -> LOP(33) -> TIS(34) -> SIH(35) -> TUM(36)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(3, 11, 1),  -- WKS
(3, 12, 2),  -- MOS
(3, 13, 3),  -- HEO
(3, 14, 4),  -- TSH
(3, 15, 5),  -- SHM
(3, 16, 6),  -- CIO
(3, 17, 7),  -- STW
(3, 18, 8),  -- CKT
(3, 19, 9),  -- TAW
(3, 20, 10), -- HIK
(3, 21, 11), -- DIH
(3, 22, 12), -- KAT
(3, 23, 13), -- SUW
(3, 24, 14), -- TKW
(3, 25, 15), -- HOM
(3, 26, 16), -- HUH
(3, 27, 17), -- ETS
(3, 28, 18), -- AUS
(3, 7, 19),  -- NAC (共享站)
(3, 29, 20), -- MEF
(3, 30, 21), -- TWW
(3, 31, 22), -- KSR
(3, 32, 23), -- YUL
(3, 33, 24), -- LOP
(3, 34, 25), -- TIS
(3, 35, 26), -- SIH
(3, 36, 27); -- TUM

-- TKL: NOP(37) -> QUB(38) -> YAT(39) -> TIK(40) -> TKO(41) -> LHP(42) -> HAH(43) -> POA(44)
-- 注意：TKO后有分支，我们采用主线+支线连续排序的方案
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(4, 37, 1),  -- NOP
(4, 38, 2),  -- QUB
(4, 39, 3),  -- YAT
(4, 40, 4),  -- TIK
(4, 41, 5),  -- TKO
(4, 42, 6),  -- LHP
(4, 43, 7),  -- HAH
(4, 44, 8);  -- POA

-- EAL: ADM(45) -> EXC(46) -> HUH(26) -> MKK(47) -> KOT(48) -> TAW(19) -> SHT(49) -> FOT(50) -> RAC(51) -> UNI(52) -> TAP(53) -> TWO(54) -> FAN(55) -> SHS(56) -> LOW(57) -> LMC(58)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(5, 45, 1),  -- ADM
(5, 46, 2),  -- EXC
(5, 26, 3),  -- HUH (共享站)
(5, 47, 4),  -- MKK
(5, 48, 5),  -- KOT
(5, 19, 6),  -- TAW (共享站)
(5, 49, 7),  -- SHT
(5, 50, 8),  -- FOT
(5, 51, 9),  -- RAC
(5, 52, 10), -- UNI
(5, 53, 11), -- TAP
(5, 54, 12), -- TWO
(5, 55, 13), -- FAN
(5, 56, 14), -- SHS
(5, 57, 15), -- LOW
(5, 58, 16); -- LMC

-- SIL: ADM(45) -> OCP(59) -> WCH(60) -> LET(61) -> SOH(62)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(6, 45, 1),  -- ADM (共享站)
(6, 59, 2),  -- OCP
(6, 60, 3),  -- WCH
(6, 61, 4),  -- LET
(6, 62, 5);  -- SOH

-- TWL: CEN(63) -> ADM(45) -> TST(64) -> JOR(65) -> YMT(66) -> MOK(67) -> PRE(68) -> SSP(69) -> CSW(70) -> LCK(71) -> MEF(29) -> LAK(8) -> KWF(72) -> KWH(73) -> TWH(74) -> TSW(75)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(7, 63, 1),  -- CEN
(7, 45, 2),  -- ADM (共享站)
(7, 64, 3),  -- TST
(7, 65, 4),  -- JOR
(7, 66, 5),  -- YMT
(7, 67, 6),  -- MOK
(7, 68, 7),  -- PRE
(7, 69, 8),  -- SSP
(7, 70, 9),  -- CSW
(7, 71, 10), -- LCK
(7, 29, 11), -- MEF (共享站)
(7, 8, 12),  -- LAK (共享站)
(7, 72, 13), -- KWF
(7, 73, 14), -- KWH
(7, 74, 15), -- TWH
(7, 75, 16); -- TSW

-- ISL: KET(76) -> HKU(77) -> SYP(78) -> SHW(79) -> CEN(63) -> ADM(45) -> WAC(80) -> CAB(81) -> TIH(82) -> FOH(83) -> NOP(37) -> QUB(38) -> TAK(84) -> SWH(85) -> SKW(86) -> HFC(87) -> CHW(88)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(8, 76, 1),  -- KET
(8, 77, 2),  -- HKU
(8, 78, 3),  -- SYP
(8, 79, 4),  -- SHW
(8, 63, 5),  -- CEN (共享站)
(8, 45, 6),  -- ADM (共享站)
(8, 80, 7),  -- WAC
(8, 81, 8),  -- CAB
(8, 82, 9),  -- TIH
(8, 83, 10), -- FOH
(8, 37, 11), -- NOP (共享站)
(8, 38, 12), -- QUB (共享站)
(8, 84, 13), -- TAK
(8, 85, 14), -- SWH
(8, 86, 15), -- SKW
(8, 87, 16), -- HFC
(8, 88, 17); -- CHW

-- KTL: WHA(89) -> HOM(25) -> YMT(66) -> MOK(67) -> PRE(68) -> SKM(90) -> KOT(48) -> LOF(91) -> WTS(92) -> DIH(21) -> CHH(93) -> KOB(94) -> NTK(95) -> KWT(96) -> LAT(97) -> YAT(39) -> TIK(40)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(9, 89, 1),  -- WHA
(9, 25, 2),  -- HOM (共享站)
(9, 66, 3),  -- YMT (共享站)
(9, 67, 4),  -- MOK (共享站)
(9, 68, 5),  -- PRE (共享站)
(9, 90, 6),  -- SKM
(9, 48, 7),  -- KOT (共享站)
(9, 91, 8),  -- LOF
(9, 92, 9),  -- WTS
(9, 21, 10), -- DIH (共享站)
(9, 93, 11), -- CHH
(9, 94, 12), -- KOB
(9, 95, 13), -- NTK
(9, 96, 14), -- KWT
(9, 97, 15), -- LAT
(9, 39, 16), -- YAT (共享站)
(9, 40, 17); -- TIK (共享站)

-- DRL: SUN(9) -> DIS(98)
INSERT INTO mtr_line_routes (line_id, station_id, sequence_order) VALUES
(10, 9, 1),   -- SUN
(10, 98, 2);  -- DIS
