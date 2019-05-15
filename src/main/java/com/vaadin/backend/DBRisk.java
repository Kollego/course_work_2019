package com.vaadin.backend;

import java.util.ArrayList;

public class DBRisk {
    private static ArrayList<PossibleRisk> risks;

    public static ArrayList<PossibleRisk> getRisks() {
        return risks;
    }

    public static void loadRisks(){
        risks = new ArrayList<>();

        /**
         * 1 - внешние риски (5 - аут, 6 -зак, 7 -общ)
         * 2 - технологические (5 - пров, 6-8 слож, 9-11 проф)
         * 3 - организационные (5 - сроки, 6-8 сплоч, 9-11 стаж менедж)
         * 4 - проектные (5 - докум, 6 - требова)
         */

        risks.add(new PossibleRisk("Риск задержки сроков из-за организационных изменений",
                        "Риск того, что организационные изменения негативно повлиять на реализацию проекта"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);

        risks.add(new PossibleRisk("Риск провала проекта из-за плохого анализа технологий в начале проекта",
                        "Риск того, что выбранная технология не «оправдает возлагаемых надежд» и не даст ожидаемого результата "));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск увеличивающейся сложности из-за недочета масштабов проекта",
                        "Риск неудачи в случае, если степень сложности сильно увеличивается из-за масштабов проекта, величины требуемых изменений или количества вовлеченных в проект сторон"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск высоких эксплуатационных издержек ",
                        "Риск того, что эксплуатационные издержки возрастут до нерентабельного уровня"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);

        risks.add(new PossibleRisk("Риск несоблюдения сроков и бюджета вследствие влияния других рисков",
                        "Риск невозможности завершить проект вовремя и в заданные временные рамки"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск неприятия системы коллективом вследствие корпоративной культуры",
                        "Отсутствие поддержки сотрудников и нежелание принимать новую систему; увеличение нагрузки на персонал в ходе внедрения и по завершению проекта."));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);

        risks.add(new PossibleRisk("Риск выбора партнера/консультанта из-за недочета всех параметров",
                        "Риск необъективного выбора консультанта, который предопределяет серьезные осложнения в ходе выполнения проекта или даже его провал"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск выбора продукта из-за недочета всех параметров",
                        "Риск необъективного выбора продукта, который не сможет соответствовать всем потребностям бизнеса"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск неверно реализованной архитектуры из-за недочета всех пареметров",
                        "Риск неверно реализованной, недостаточно гибкой архитектуры, которая не будет покрывать все потенциальные бизнес-процессы"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск несоответствия долгосрочным целям бизнеса из-за отсутствия стратегии ",
                        "Отсутствие у руководства предприятия целостной долгосрочной стратегии в области ИТ "));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(6);

        risks.add(new PossibleRisk("Риск задержки сроков из-за неверной оценки масштаба проекта",
                        "Отставание по графику на разных этапах проекта"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск задержки сроков из-за частых изменений требований",
                        "Отставание по графику на разных этапах проекта"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(6);

        risks.add(new PossibleRisk("Риск задержки сроков из-за опаздывания поставщиков",
                        "Отставание по графику на разных этапах проекта"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(5);

        risks.add(new PossibleRisk("Риск превышения бюджета из-за увеличения стоимости сторонних лицензий",
                        "Увеличение количества затраченных на проект средств"));
        risks.get(risks.size()-1).setType(1);

        risks.add(new PossibleRisk("Риск изменения требований из-за неполной проработки требований",
                        "Требования поступают не на этапе выявления требований"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);

        risks.add(new PossibleRisk("Риск изменения требований из-за неопределенности в понимании проекта руководством заказчика",
                        "Требования поступают не на этапе выявления требований"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);

        risks.add(new PossibleRisk("Риск потери информации о проекте из-за стихийного бедствия",
                        "Потеря всех документов, касающихся проекта"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(7);

        risks.add(new PossibleRisk("Риск длительной обработки изменений требований из-за отсутствия методологии",
                        "Каждое изменение требований обрабатывается значительное время"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);

        risks.add(new PossibleRisk("Риск прерывания финансирования из-за вмешательства гос. органов",
                        "Деньги перестали поступать на расчетный счет или операции с расчетным счетом невозможны"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(7);

        risks.add(new PossibleRisk("Риск потери прибыли от проекта из-за изменения налоговой базы",
                        "Вынужденное закрытие проекта, отказ от выполнения проекта из-за неполучения прибыли"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(7);

        risks.add(new PossibleRisk("Риск невозможности получения информации от заказчика из-за препятствования сотрудников",
                        "Закрытие проекта, расторжение контракта"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);

        risks.add(new PossibleRisk("Риск ошибочного выбора технологий из-за неполноты техусловий",
                        "По техусловиям требуется другая технология ERP"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск неправильного выполнения бизнес-функции из-за критических ошибок ",
                        "На этапе тестирования выявлены ошибочные вычисления или некорректное заполнение БД"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск необходимости дополнительного оборудования из-за неправильного расчета",
                        "Неправильно рассчитана спецификация оборудования"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск задержки сроков и необходимости реализации дополнительных функций из-за изменения нефункциональных требований",
                        "Изменились требования к безопасности, надежности"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(6);
        risks.add(new PossibleRisk("Риск задержки сроков и превышения бюджета из-за затянувшейся реализации",
                        "Программисты дают слишком оптимистичные оценки, трудности при реализации из-за особенностей технологии"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск задержки сроков и превышения бюджета из-за увольнения специалиста",
                        "Ведущий специалист проектировал систему и координировал работу других членов команды"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.get(risks.size()-1).addCriteria(11);

        risks.add(new PossibleRisk("Риск срыва сроков проекта из-за задержки сроков финансирования проекта заказчиком",
                        "Руководство компании не обеспечивает проект своевременным финансированием, постоянные задержки связанные с ожиданием поступления средств."));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(6);
        risks.add(new PossibleRisk("Риск увеличения стоимости проекта из-за неверной оценки стоимости проекта",
                        "Необходимость постоянной переоценки стоимости проекта, много времени уходит на обсуждение целесообразности финансирования  "));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск увеличения сроков проекта, стоимости проекта из-за неэффективной координации проекта",
                        "Отставание по графику проекта из-за задержек с выполнением работ"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(9);
        risks.add(new PossibleRisk("Риск увеличения сроков проекта из-за неверной оценки сроков выполнения работ",
                        "Постоянное внесение изменений в план проекта"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск увеличения стоимости проекта из-за выбора неверных технологий и технолог. стандартов.",
                        "Изначально были выбраны технологии, которые не соответствуют целям проекта. Необходимость проведения повторного анализа на соответствие технологий "));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск несоответствия продукта требуемым нормам качества из-за несоблюдения технологических стандартов",
                        "Технологии применяются не правильно либо не по назначению, что приводит к несоответствию нормам качества продукта."));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск увеличения сроков проекта из-за слабости менеджера разработки",
                        "Менеджер проекта не справляется со своими обязанностями по проекту. Замена менеджера или повышение квалификации текущего менеджера приводит к увеличению сроков "));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(9);
        risks.add(new PossibleRisk("Риск увеличения сроков проекта из-за несвоевременного информирования сотрудников ",
                        "Не все заинтересованные сотрудники изначально информированы по ходе проекта. Выявление новых заинтересованных лиц повлечет к большому количеству изменений"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск выбора неправильного оборудования или платформы для разработки",
                        "При неправильном выборе оборудования или платформы для реализации системы, возможно, что дальнейшее развитие системы станет под вопросом."));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск подбора неправильной проектной команды",
                        "Реализация всего проекта ставится под сомнение, либо отодвигается на неопределенный срок"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск непрофессиональной реализации системы",
                        "Возможно возникновение проблем после сдачи системы заказчику, проблемы масштабирования системы, репутационные риски"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.add(new PossibleRisk("Риск недостаточности тестирования реализованной системы",
                        "Если решение было протестировано в недостаточной мере, то возможно появление непредвиденных ситуаций, сбоев системы, финансовая компенсация потерь заказчика, репутационный риск."));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(9);
        risks.add(new PossibleRisk("Риск нехватки опыта у руководителя проекта",
                        "Неправильно организованные процессы внутри команды, срыв сроков, ненадлежащее качество проекта."));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(9);
        risks.add(new PossibleRisk("Риск недооценки сроков выполнения проекта",
                        "При неверной оценке сроков выполнения проекта, проект фактически может быть выполнен в убыток, репутационный риск"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск недооценки стоимости проекта",
                        "При неверной оценке стоимости выполнения проекта, проект фактически может быть выполнен в убыток, репутационный риск"));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск несоблюдения контрактных обязательств подрядчиками",
                        "Срыв срока поставки системы заказчику, перерасход бюджета проекта"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск возникновения сложностей при интеграции системы в инфраструктуру заказчика",
                        "Срыв срока поставки системы заказчику, перерасход бюджета проекта"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.get(risks.size()-1).addCriteria(11);
        risks.add(new PossibleRisk("Риск возникновения непредвиденных ситуаций в системе после сдачи ее заказчику",
                        "Перерасход бюджета проекта, репутационные риски компании"));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.get(risks.size()-1).addCriteria(11);
        risks.add(new PossibleRisk("Риск значительного перерасходования бюджета проекта из-за его неправильной оценки",
                        "Значительное перерасходование бюджета выделенного на проект "));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.add(new PossibleRisk("Риск невозможности объединить внедряемую систему и существующие информационные системы на предприятии из-за их различной архитектуры и отличиях в технологиях",
                        "Возникают неразрешимые проблемы при попытках интеграции внедряемой системы и существующих информационных систем, необходимых для работы предприятия, "));
        risks.get(risks.size()-1).setType(2);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.get(risks.size()-1).addCriteria(8);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(10);
        risks.get(risks.size()-1).addCriteria(11);
        risks.add(new PossibleRisk("Риск несоответствия системы ожиданиям руководства предприятия из-за неправильной интерпретации требований к качеству системы аналитиками",
                        "Внедряемая система не соответствует ожиданиям руководства предприятия, руководство критикует систему и высказывает пожелания по ее замене."));
        risks.get(risks.size()-1).setType(4);
        risks.get(risks.size()-1).addCriteria(5);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.add(new PossibleRisk("Риск нехватки специалистов в команде внедрения из-за недооцененного масштаба проекта и объема работ",
                        "Специалисты команды внедрения не успевают справиться со своими задачами в течение рабочего дня, работают сверхурочно чтобы уложиться в сроки."));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(9);
        risks.get(risks.size()-1).addCriteria(6);
        risks.add(new PossibleRisk("Конфликты между членами команды внедрения из-за отсутствия единого понимания стоящих перед ними задач ",
                        "Члены проектной команды не могут договориться, как лучше решать стоящую перед ними задачу, постоянные конфликты между ними"));
        risks.get(risks.size()-1).setType(3);
        risks.get(risks.size()-1).addCriteria(6);
        risks.get(risks.size()-1).addCriteria(7);
        risks.add(new PossibleRisk("Риск банкротства предприятия из-за экономического кризиса",
                        "Предприятие, затронутое экономическим кризисом, объявляет о банкротстве"));
        risks.get(risks.size()-1).setType(1);
        risks.get(risks.size()-1).addCriteria(7);
    }

}
