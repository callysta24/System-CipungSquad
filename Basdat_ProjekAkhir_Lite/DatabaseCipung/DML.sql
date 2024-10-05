USE cipungSquad

INSERT INTO Transaksi (invoice, tanggal, kasir, pelanggan, item, total_transaksi, dibayar, kembalian)
VALUES
('TRX#230923JCO164', '23/09/2023', 'sulastri', 'Pelanggan', 1, 20000, 20000, 0),
('TRX#230923VZC698', '23/09/2023', 'sulastri', 'Pelanggan', 1, 30000, 30000, 0),
('TRX#230923RNG442', '23/09/2023', 'intan', 'Pelanggan', 2, 45000, 45000, 0),
('TRX#230923HDS398', '23/09/2023', 'intan', 'Pelanggan', 1, 35000, 35000, 0),
('TRX#230923PHD240', '23/09/2023', 'intan', 'Pelanggan', 1, 30000, 30000, 0),
('TRX#230924JKJ715', '24/09/2023', 'intan', 'Pelanggan', 2, 20000, 20000, 0),
('TRX#230924BJR787', '24/09/2023', 'intan', 'Pelanggan', 3, 3000, 23000, 0),
('TRX#230924OOS880', '24/09/2023', 'intan', 'Pelanggan', 4, 123000, 123000, 0),
('TRX#230924XVR675', '24/09/2023', 'intan', 'Pelanggan', 1, 55000, 55000, 0),
('TRX#230924IID454', '24/09/2023', 'intan', 'Pelanggan', 1, 25000, 25000, 0),
('TRX#230925WSY180', '25/09/2023', 'intan', 'Pelanggan', 1, 15000, 15000, 0),
('TRX#230925ASJ705', '25/09/2023', 'intan', 'Pelanggan', 2, 80000, 80000, 0),
('TRX#230925YB319', '25/09/2023', 'Sulastri', 'Pelanggan', 1, 20000, 20000, 0),
('TRX#230925UUB655', '25/09/2023', 'Sulastri', 'Pelanggan', 1, 10000, 10000, 0),
('TRX#230925BKP854', '25/09/2023', 'Sulastri', 'Pelanggan', 1, 35000, 35000, 0);

-- Insert data into the Barang table
INSERT INTO Barang (id_barang, nama_barang, harga_satuan, kategori)
VALUES
('B001', 'kabel wellcom type c TOPLES', 25000, 'Hp'),
('B002', 'Kabel Type C 3A Welcomm', 35000, 'Hp'),
('B003', 'charger universal', 30000, 'Hp'),
('B004', 'Kabel Data Macaron Type C', 15000, 'Hp'),
('B005', 'FD Sandisk 2gb', 35000, 'Laptop'),
('B006', 'gantungan hp merk', 10000, 'Hp'),
('B007', 'Kabel data Mikro makaron 2.4A', 10000, 'Hp'),
('B008', 'pelindung kabel', 3000, 'Hp'),
('B009', 'SP smart 6/14hr', 18000, 'Lainnya'),
('B010', 'FD sandisk 8', 70000, 'Laptop'),
('B011', 'Adaptor Log On', 20000, 'Hp'),
('B012', 'Adaptor usb type c', 55000, 'Hp'),
('B013', 'kabel mikro Foome', 15000, 'Hp'),
('B014', 'kabel wellcom iphone (pack/toples)', 25000, 'Hp'),
('B015', 'hf v gen VEP1-19', 35000, 'Hp'),
('B016', 'Girls Unicorn Int. Popsocket', 89500, 'Hp'),
('B017', 'Vivo V15 Magnetic Glass Premium Case 2in1', 45000, 'Hp'),
('B018', 'Tempelan HP Gurita Karet Universal', 5890, 'Hp'),
('B019', 'Flip Cover Oppo A7 Standing Mirror Full', 30000, 'Hp'),
('B020', 'Holder Hp Mobil Dashboard', 40000, 'Hp'),
('B021', 'Mouse Wireless ROBOT M210 2.4GHz', 75000, 'Laptop'),
('B022', 'Cooling pad usb wired QUINTON', 110000, 'Laptop'),
('B023', 'TOSHIBA PORTABLE External Hard Drive', 250000, 'Laptop'),
('B024', 'REXUS Battlefire KX2 Semi Mechanical', 334100, 'Laptop'),
('B025', 'Mouse Pad Trakpad Alas Robot MP01', 7000, 'Laptop'),
('B026', 'TAS LAPTOP CASE LAPTOP 14 INCH', 60000, 'Laptop'),
('B027', 'Adaptor Charger Laptop Lenovo Universal', 250000, 'Laptop'),
('B028', 'Keyboard protector notebook 14 inchi', 10000, 'Laptop');

-- Insert data into the Transaksi_Barang table
INSERT INTO Transaksi_Barang (invoice, id_barang, nama_barang, jumlah, sub_total, disc)
VALUES
('TRX#230923JCO164', 'B001', 'kabel wellcom type c TOPLES', 1, 25000, 5000),
('TRX#230923VZC698', 'B002', 'Kabel Type C 3A Welcomm', 1, 35000, 5000),
('TRX#230923RNG442', 'B003', 'charger universal', 1, 30000, 0),
('TRX#230923RNG442', 'B004', 'Kabel Data Macaron Type C', 1, 15000, 0),
('TRX#230923HDS398', 'B005', 'FD Sandisk 2gb', 1, 35000, 0),
('TRX#230923PHD240', 'B003', 'charger universal', 1, 30000, 0),
('TRX#230924JKJ715', 'B006', 'gantungan hp merk', 1, 10000, 0),
('TRX#230924JKJ715', 'B007', 'Kabel data Mikro makaron 2.4A', 1, 10000, 0),
('TRX#230924BJR787', 'B007', 'Kabel data Mikro makaron 2.4A', 2, 20000, 0),
('TRX#230924BJR787', 'B008', 'pelindung kabel', 1, 3000, 0),
('TRX#230924OOS880', 'B009', 'SP smart 6/14hr', 1, 18000, 0),
('TRX#230924OOS880', 'B010', 'FD sandisk 8', 1, 70000, 0),
('TRX#230924OOS880', 'B011', 'Adaptor Log On', 1, 20000, 0),
('TRX#230924OOS880', 'B004', 'Kabel Data Macaron Type C', 1, 15000, 0),
('TRX#230924XVR675', 'B012', 'Adaptor usb type c', 1, 55000, 0),
('TRX#230924IID454', 'B001', 'kabel wellcom type c TOPLES', 1, 25000, 0),
('TRX#230925WSY180', 'B013', 'kabel mikro Foome', 1, 15000, 0),
('TRX#230925ASJ705', 'B012', 'Adaptor usb type c', 1, 55000, 0),
('TRX#230925ASJ705', 'B014', 'kabel wellcom iphone (pack/toples)', 1, 25000, 0),
('TRX#230925YB319', 'B011', 'Adaptor Log On', 1, 20000, 0),
('TRX#230925UUB655', 'B007', 'kabel data Mikro makaron 2.4A', 1, 10000, 0),
('TRX#230925BKP854', 'B015', 'hf v gen VEP1-19', 1, 35000, 0);
