create table mahasiswa(
    nim varchar2(255) not null constraint mahasiswa_pk primary key,
    nama varchar2(255),
    tgl_lahir varchar2(255)
);

create table mata_kuliah(
    kode VARCHAR2(10) not null constraint mata_kuliah_pk primary key,
    nama VARCHAR2(255),
    sks number(11)
);
  
create table dosen(
    nid varchar2(255) not null constraint dosen_pk primary key,
    nama varchar2(255),
    kelompok_keahlian varchar2(255),
    tgl_lahir varchar2(255)
);

create table enroll(
    enroll_num number(11) not null constraint enroll_pk primary key,
    nim varchar2(255) not null,
    kode varchar2(10) not null,
    nilai num(2),
    constraint enroll_fk1 foreign key(nim) references mahasiswa(nim) on delete cascade,
    constraint enroll_fk2 foreign key(kode) references mata_kuliah(kode) on delete cascade
);

create table taken(
    taken_num number(11) not null constraint taken_pk primary key,
    nik varchar2(255) not null,
    kode varchar2(10) not null,
    constraint taken_fk1 foreign key(nik) references dosen(nik) on delete cascade,
    constraint taken_fk2 foreign key(kode) references mata_kuliah(kode) on delete cascade
);