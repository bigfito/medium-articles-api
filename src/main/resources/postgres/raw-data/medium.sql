create database medium;

create table articles
(
    id_article   bigserial
        constraint articles_pk
            primary key,
    id           varchar(20),
    url          text,
    title        text,
    subtitle     text,
    first_para   text,
    image        varchar(20),
    claps        double precision
        constraint check_claps
            check (claps >= (0)::double precision),
    responses    double precision
        constraint check_responses
            check (responses >= (0)::double precision),
    reading_time double precision
        constraint check_reading_time
            check (reading_time >= (0)::double precision),
    publication  varchar(150),
    date         date
);

alter table articles
    owner to postgres;

create index articles_id_index
    on articles (id);