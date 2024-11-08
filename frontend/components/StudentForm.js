import $ from "jquery";
import {API_BASE_URL} from "../api/general.js";
import {Button} from "./Button.js";  // Импортируем класс Button

export class StudentForm {
    constructor() {
        this.$form = $('<form>')
            .addClass('student-form');
    }

    createInputField(name, placeholder, type = 'text') {
        return $('<div>')
            .addClass('input-group')
            .append(
                $('<label>')
                    .text(placeholder),
                $('<input>')
                    .attr('type', type)
                    .attr('name', name)
                    .attr('placeholder', placeholder)
                    .prop('required', true)
            );
    }

    async handleSubmit(event) {
        const studentData = {
            firstName: this.$form.find('input[name="firstName"]').val(),
            lastName: this.$form.find('input[name="lastName"]').val(),
            patronymic: this.$form.find('input[name="patronymic"]').val(),
            birthday: this.$form.find('input[name="birthday"]').val(),
            group: this.$form.find('input[name="group"]').val()
        };

        try {

            await $.ajax({
                url: `${API_BASE_URL}/students`,
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify(studentData),
            });

            this.$form[0].reset();
        } catch (err) {
            console.error("Error when creating a student:", err);
        }
    }

    render() {
        this.$form.append(this.createInputField('firstName', 'Имя'));
        this.$form.append(this.createInputField('lastName', 'Фамилия'));
        this.$form.append(this.createInputField('patronymic', 'Отчество'));
        this.$form.append(this.createInputField('birthday', 'Дата рождения', 'date'));
        this.$form.append(this.createInputField('group', 'Группа'));

        const $createButton = new Button("Создать", () => this.handleSubmit()).render();

        this.$form.append($createButton);

        return this.$form;
    }
}
