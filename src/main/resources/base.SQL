--
-- PostgreSQL database dump
--

-- Dumped from database version 15.6
-- Dumped by pg_dump version 15.6

-- Started on 2024-04-23 13:41:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 24583)
-- Name: developer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developer (
    developer_name character varying(255) DEFAULT NULL::character varying,
    age bigint NOT NULL,
    education character varying(255) DEFAULT NULL::character varying,
    developer_id integer NOT NULL
);


ALTER TABLE public.developer OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24607)
-- Name: developer_developer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developer_developer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developer_developer_id_seq OWNER TO postgres;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 218
-- Name: developer_developer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.developer_developer_id_seq OWNED BY public.developer.developer_id;


--
-- TOC entry 215 (class 1259 OID 24590)
-- Name: phone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.phone (
    phone_id bigint NOT NULL,
    developer_id bigint NOT NULL,
    phone_type character varying(20) NOT NULL,
    phone_number character varying(255) NOT NULL
);


ALTER TABLE public.phone OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24593)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
    project_id bigint NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.project OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24596)
-- Name: project2developer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project2developer (
    project_id bigint NOT NULL,
    developer_id bigint NOT NULL
);


ALTER TABLE public.project2developer OWNER TO postgres;

--
-- TOC entry 3187 (class 2604 OID 24608)
-- Name: developer developer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developer ALTER COLUMN developer_id SET DEFAULT nextval('public.developer_developer_id_seq'::regclass);


--
-- TOC entry 3338 (class 0 OID 24583)
-- Dependencies: 214
-- Data for Name: developer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Эсергей Смирновюв', 56, 'Институт', 1);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Полег Андреевъг', 47, 'Университет', 2);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Яандрей Андреевсй', 22, 'Институт', 3);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ииван Ивановцд', 42, 'Университет', 4);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Яигорь Федоровби', 63, 'Институт', 5);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ливан Федоровнв', 61, 'Университет', 6);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Зандрей Сергеевбю', 62, 'Институт', 7);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Гиван Сергеевдф', 43, 'Университет', 8);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Дсергей Андреевкю', 47, 'Институт', 9);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чигорь Ивановзт', 39, 'Университет', 10);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Сандрей Смирновфд', 53, 'Институт', 11);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Бдмитрий Дмитриевлэ', 24, 'Университет', 12);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Цигорь Федоровбн', 31, 'Институт', 13);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Псергей Смирновёс', 26, 'Университет', 14);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ядмитрий Федоровнй', 47, 'Институт', 15);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ъигорь Андреевбл', 52, 'Университет', 16);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Колег Сергеевуе', 21, 'Институт', 17);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Мдмитрий Дмитриевёу', 58, 'Университет', 18);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Юигорь Ивановиф', 22, 'Институт', 19);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Диван Дмитриевкю', 38, 'Университет', 20);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Эигорь Смирновлй', 63, 'Институт', 21);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Хсергей Ивановжы', 50, 'Университет', 22);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Юдмитрий Сергеевню', 49, 'Институт', 23);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ыолег Дмитриеввл', 28, 'Университет', 24);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Асергей Федоровеъ', 35, 'Институт', 25);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чиван Сергеевлю', 55, 'Университет', 26);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Зандрей Федоровфй', 40, 'Институт', 27);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Эиван Федоровцё', 50, 'Университет', 28);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Живан Сергеевъз', 51, 'Институт', 29);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Лигорь Ивановбт', 51, 'Университет', 30);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Лигорь Сергеевдб', 29, 'Институт', 31);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Сдмитрий Дмитриевут', 28, 'Университет', 32);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Оигорь Сергеевыз', 39, 'Институт', 33);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Жигорь Дмитриеврр', 22, 'Университет', 34);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Пиван Дмитриевнв', 52, 'Институт', 35);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Волег Федоровгю', 48, 'Университет', 36);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ёигорь Дмитриевяс', 29, 'Институт', 37);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ядмитрий Сергеевюь', 41, 'Университет', 38);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ьиван Федоровнс', 59, 'Институт', 39);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Уандрей Дмитриевфю', 50, 'Университет', 40);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Оиван Сергеевър', 42, 'Институт', 41);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Тигорь Андрееваю', 49, 'Университет', 42);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Оиван Федоровоы', 48, 'Институт', 43);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Оолег Смирновзэ', 41, 'Университет', 44);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Толег Ивановчс', 58, 'Институт', 45);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ъдмитрий Ивановол', 37, 'Университет', 46);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чолег Дмитриевгн', 55, 'Институт', 47);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Уиван Смирновкд', 23, 'Университет', 48);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Тандрей Федоровжп', 54, 'Институт', 49);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Гигорь Федороваю', 27, 'Университет', 50);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Яиван Андреевдз', 39, 'Институт', 51);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Всергей Андреевмц', 44, 'Университет', 52);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ёиван Ивановбм', 33, 'Институт', 53);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Лигорь Сергеевуд', 20, 'Университет', 54);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Эолег Федоровяю', 36, 'Институт', 55);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Миван Дмитриевюь', 37, 'Университет', 56);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Солег Смирновдт', 41, 'Институт', 57);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чандрей Андреевтз', 25, 'Университет', 58);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Иолег Федоровъм', 30, 'Институт', 59);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ьсергей Смирновси', 55, 'Университет', 60);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чиван Сергеевбэ', 37, 'Институт', 61);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Здмитрий Сергеевор', 55, 'Университет', 62);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Жолег Ивановтг', 64, 'Институт', 63);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Зигорь Сергеевор', 31, 'Университет', 64);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Дсергей Федоровак', 41, 'Институт', 65);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Аиван Дмитриевхх', 41, 'Университет', 66);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Йандрей Сергеевбъ', 49, 'Институт', 67);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Пандрей Сергеевсг', 41, 'Университет', 68);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ндмитрий Смирновъы', 39, 'Институт', 69);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Эсергей Дмитриевях', 31, 'Университет', 70);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ыдмитрий Сергеевдю', 48, 'Институт', 71);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Адмитрий Дмитриевпг', 57, 'Университет', 72);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Дсергей Ивановжя', 33, 'Институт', 73);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Вдмитрий Андреевтю', 49, 'Университет', 74);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ъсергей Федоровхы', 59, 'Институт', 75);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Чдмитрий Андреевнл', 39, 'Университет', 76);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Аолег Сергеевёт', 49, 'Институт', 77);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Иигорь Ивановчч', 51, 'Университет', 78);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ядмитрий Федоровбо', 52, 'Институт', 79);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Вигорь Смирновэр', 63, 'Университет', 80);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ригорь Ивановпх', 50, 'Институт', 81);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Риван Андрееврс', 40, 'Университет', 82);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Оолег Ивановнс', 60, 'Институт', 83);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Иолег Ивановчп', 36, 'Университет', 84);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Идмитрий Андреевёз', 48, 'Институт', 85);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Усергей Федоровгс', 44, 'Университет', 86);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ддмитрий Андреевря', 48, 'Институт', 87);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Всергей Федоровеь', 38, 'Университет', 88);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Иандрей Ивановэв', 38, 'Институт', 89);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Юдмитрий Андреевех', 60, 'Университет', 90);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Риван Дмитриевлё', 50, 'Институт', 91);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Зиван Сергеевяо', 52, 'Университет', 92);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Тандрей Федоровйа', 23, 'Институт', 93);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ниван Смирновюм', 29, 'Университет', 94);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ъигорь Сергеевом', 48, 'Институт', 95);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Фдмитрий Сергеевцу', 61, 'Университет', 96);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Ясергей Андреевчь', 25, 'Институт', 97);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Иигорь Ивановкг', 49, 'Университет', 98);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Жигорь Сергеевяы', 43, 'Институт', 99);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Андрей Чернышев', 44, 'ОГТИ', 101);
INSERT INTO public.developer (developer_name, age, education, developer_id) VALUES ('Андрей Чернышев', 44, 'ОГТИ', 102);


--
-- TOC entry 3339 (class 0 OID 24590)
-- Dependencies: 215
-- Data for Name: phone; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.phone (phone_id, developer_id, phone_type, phone_number) VALUES (1, 1, 'WORK', '+79058977107');
INSERT INTO public.phone (phone_id, developer_id, phone_type, phone_number) VALUES (2, 1, 'PERSONAL', '+73532255890');
INSERT INTO public.phone (phone_id, developer_id, phone_type, phone_number) VALUES (3, 1, 'ADDITIONAL', '+73532255821');
INSERT INTO public.phone (phone_id, developer_id, phone_type, phone_number) VALUES (4, 88, 'ADDITIONAL', '+7353227889');
INSERT INTO public.phone (phone_id, developer_id, phone_type, phone_number) VALUES (5, 88, 'WORK', '+79223458721');


--
-- TOC entry 3340 (class 0 OID 24593)
-- Dependencies: 216
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.project (project_id, title) VALUES (1, 'Сбербанк-Б2Б');
INSERT INTO public.project (project_id, title) VALUES (2, 'Сбербанк-розница');
INSERT INTO public.project (project_id, title) VALUES (3, 'Альфа Страхование');
INSERT INTO public.project (project_id, title) VALUES (4, 'ВТБ Лизинг');
INSERT INTO public.project (project_id, title) VALUES (5, 'Сбермаркет');
INSERT INTO public.project (project_id, title) VALUES (6, 'Мегамаркет');
INSERT INTO public.project (project_id, title) VALUES (7, 'Логистика +');
INSERT INTO public.project (project_id, title) VALUES (8, 'Билеты');


--
-- TOC entry 3341 (class 0 OID 24596)
-- Dependencies: 217
-- Data for Name: project2developer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.project2developer (project_id, developer_id) VALUES (7, 15);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (6, 24);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (8, 26);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (1, 27);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (8, 41);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (1, 42);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (3, 45);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (7, 45);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (4, 46);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (6, 56);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (5, 57);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (3, 58);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (4, 65);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (5, 65);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (2, 69);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (8, 70);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (4, 74);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (2, 79);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (5, 80);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (3, 82);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (7, 82);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (6, 84);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (1, 88);
INSERT INTO public.project2developer (project_id, developer_id) VALUES (2, 88);


--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 218
-- Name: developer_developer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.developer_developer_id_seq', 102, true);


--
-- TOC entry 3189 (class 2606 OID 24615)
-- Name: developer developer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developer
    ADD CONSTRAINT developer_pkey PRIMARY KEY (developer_id);


--
-- TOC entry 3191 (class 2606 OID 24602)
-- Name: phone phone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phone
    ADD CONSTRAINT phone_pkey PRIMARY KEY (phone_id);


--
-- TOC entry 3195 (class 2606 OID 24606)
-- Name: project2developer project2developer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project2developer
    ADD CONSTRAINT project2developer_pkey PRIMARY KEY (project_id, developer_id);


--
-- TOC entry 3193 (class 2606 OID 24604)
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (project_id);


-- Completed on 2024-04-23 13:41:13

--
-- PostgreSQL database dump complete
--

