create table mahasiswa(
    nim varchar2(255) not null constraint mahasiswa_pk primary key,
    nama_mhs varchar2(255),
    tgl_lahir varchar2(255)
);

create table mata_kuliah(
    kode_mk VARCHAR2(10) not null constraint mata_kuliah_pk primary key,
    nama_mk VARCHAR2(255),
    sks number(11)
    nid varchar2(255),
    constraint enroll_fk1 foreign key(nim) references mahasiswa(nim) on delete cascade
);
  
create table dosen(
    nid varchar2(255) not null constraint dosen_pk primary key,
    nama_dosen varchar2(255),
    kelompok_keahlian varchar2(255),
    tgl_lahir varchar2(255)
);

create table taken(
    taken_num number(11) not null constraint taken_pk primary key,
    nik varchar2(255) not null,
    kode varchar2(10) not null,
    constraint taken_fk1 foreign key(nik) references dosen(nik) on delete cascade,
    constraint taken_fk2 foreign key(kode) references mata_kuliah(kode) on delete cascade
);

create table gedung(
    kode_gedung varchar2(10) not null constraint gedung_pk primary key,
    nama_gedung varchar2(255)
);

create table ruangan(
    no_ruangan VARCHAR2(10) not null constraint ruangan_pk primary key,
    kode_gedung varchar2(10),
    kapasitas number(10),
    constraint ruangan_fk foreign key(kode_gedung) references gedung(kode_gedung) on delete cascade
);

create table jadwal(
    id_jadwal varchar2(10) not null constraint jadwal_pk primary key,
    kode_mk varchar2(10),
    no_ruangan varchar2(10),
    waktu varchar2(255),
    constraint jadwal_fk1 foreign key(kode_mk) references mata_kuliah(kode_mk) on delete cascade,
    constraint jadwal_fk2 foreign key(no_ruangan) references ruangan(no_ruangan) on delete cascade
);

create table enroll(
    no_enroll number(10) not null constraint enroll_pk primary key,
    id_jadwal varchar2(10),
    nim varchar2(255),
    constraint enroll_fk1 foreign key(id_jadwal) references jadwal(id_jadwal) on delete cascade,
    constraint enroll_fk2 foreign key(nim) references mahasiswa(nim) on delete cascade
);
    
INSERT INTO mata_kuliah VALUES ('PBO', 'PBO', 3, 'D1');
INSERT INTO mata_kuliah VALUES ('SJK', 'Jarkom', 3, 'D2');
INSERT INTO mata_kuliah VALUES ('ENG', 'English', 3, 'D3');
INSERT INTO mata_kuliah VALUES ('KLS', 'Kalkulus', 4, 'D4');

INSERT INTO GEDUNG (KODE_GEDUNG, NAMA_GEDUNG) VALUES ('G01' , 'Cacuk');
INSERT INTO GEDUNG (KODE_GEDUNG, NAMA_GEDUNG) VALUES ('G02' , 'Kolor');
INSERT INTO GEDUNG (KODE_GEDUNG, NAMA_GEDUNG) VALUES ('G03' , 'Burj-Khalifa');
);

insert into dosen values ('D1','Erli Nasution','SIDE',null);
insert into dosen values ('D2','Dita Oktaria','TELE',null);
insert into dosen values ('D3','Yuningsih','BAHASA',null);
insert into dosen values ('D4','Bambang','MATEMATIKA',null);

insert into ruangan values ('R01','G01',30);

insert into enroll values ('1','jadwal1','1303184048');
insert into enroll values ('2','jadwal1','1303181077');
insert into enroll values ('3','jadwal1','1303184065');